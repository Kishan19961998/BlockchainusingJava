package com.Blockchain.Start;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlockchainTechApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
		SpringApplication.run(BlockchainTechApplication.class, args);
		
		SmokingTest st=new SmokingTest();
		st.Blockchain();
		
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		keyGen.initialize(512);
		
		KeyPair pair = keyGen.generateKeyPair();
		PrivateKey priv = pair.getPrivate();
		PublicKey pub = pair.getPublic();
		
		System.out.println("pub: "+pub);
		
		System.out.println("Priv: "+priv);
	}

}
