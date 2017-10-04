package com.example.instabanking;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;


@Controller
public class CorpUserMaintController {
	
	String mess="";
	UserInfo n = new UserInfo();
	@Autowired
	private InfoRepository infoRepository;
	@RequestMapping(value="/corpusermaint",method=RequestMethod.GET)
	public String init()
	{return "corpusermaint";}
	@RequestMapping(value="/corpusermaint",method=RequestMethod.POST)
	public String disp(@RequestParam("pan") String pan,@RequestParam("name") String name,@RequestParam("mailid") String mailid,@RequestParam("password") String password,Model model)
	{
		
		try
		{	
			n = infoRepository.findBypan(pan);
			n.setmailid(mailid);
			n.setpassword(password);
			n.setname(name);
			infoRepository.save(n);
			model.addAttribute("message","Your data has been updated");
			voiceprocessing("Your data has been updated");
			return "corpusermaint";
		}
		
		catch(Exception e)
		
		{ 
			n=new UserInfo(pan,name,mailid,password);
			infoRepository.save(n);
			mess="Hello "+name+ " your record has been successfully created";
			model.addAttribute("message","Your record has been created");
			voiceprocessing(mess);
			return "corpusermaint";
		}
	}	
		public void voiceprocessing(String text1)
		{   String text=text1;
			TextToSpeech service = new TextToSpeech();
	        service.setUsernameAndPassword("ebd808dd-22f2-49cc-8ba5-ab774e440097","yi4YdYte8gQx");
				try {
					   InputStream stream = service.synthesize(text, Voice.EN_ALLISON,
					    AudioFormat.WAV).execute();
					  InputStream in = WaveUtils.reWriteWaveHeader(stream);
			
					 OutputStream out = new FileOutputStream("hello_world.wav");
					  byte[] buffer = new byte[1024];
					  int length;
					  while ((length = in.read(buffer)) > 0) {
					    out.write(buffer, 0, length);
					  }
					  
					  out.close();
					  in.close();
					  stream.close();
					
					  File audioFile=new File("hello_world.wav");
					  AudioInputStream audioStream=AudioSystem.getAudioInputStream(audioFile);
					  javax.sound.sampled.AudioFormat format=audioStream.getFormat();
					  DataLine.Info info=new DataLine.Info(Clip.class,format);
					  Clip audioClip=(Clip)AudioSystem.getLine(info);
					  audioClip.open(audioStream);
					  audioClip.start();
					  boolean playCompleted=false;
					  while(!playCompleted)
					  {try
					  {Thread.sleep(1000);
					  }
					  catch(InterruptedException ex)
					  {}
					  }

					  audioClip.close();
					  
				} catch (Exception e) {
					// Log something and return an error message
				} 
		
		}
		
}

