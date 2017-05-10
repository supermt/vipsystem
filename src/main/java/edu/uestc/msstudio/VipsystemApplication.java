package edu.uestc.msstudio;

import edu.uestc.msstudio.edu.uestc.msstudio.vipsystem.model.Userinfo;
import edu.uestc.msstudio.edu.uestc.msstudio.vipsystem.model.VIPRank;
import edu.uestc.msstudio.edu.uestc.msstudio.vipsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VipsystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(VipsystemApplication.class, args);
	}


}
