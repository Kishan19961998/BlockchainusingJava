package com.Blockchain.Start;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import ch.qos.logback.classic.Level;

/**
 * @author Kbyrosu
 *
 */
public class BlockData {
	private String hash;
	private String previousHash;
	private String data;
	private long timeStamp;
	private int nonce;
	
	public BlockData(String data, String previousHash, long timeStamp) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = timeStamp;
        this.hash = calculateBlockHash();
    }
	
	public String getHash() {
		return hash;
	}
	public String getPreviousHash() {
		return previousHash;
	}
	public String getData() {
		return data;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public int getNonce() {
		return nonce;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}

	public String calculateBlockHash() {
	    String dataToHash = previousHash 
	      + Long.toString(timeStamp) 
	      + Integer.toString(nonce) 
	      + data;
	    MessageDigest digest = null;
	    byte[] bytes = null;
	    try {
	        digest = MessageDigest.getInstance("SHA-256");
	        bytes = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
	    } catch (NoSuchAlgorithmException ex) {
	        System.out.println(Level.ERROR+"--"+ ex.getMessage());
	    }
	    StringBuffer buffer = new StringBuffer();
	    for (byte b : bytes) {
	        buffer.append(String.format("%02x", b));
	    }
	    return buffer.toString();
	}
	
	public String mineBlock(int prefix) {
	    //String prefixString = "00"; //new String(new char[prefix]).replace('\0', '0');
		String prefixString = new String(new char[prefix]).replace('\0', '0');
		while (!hash.substring(0, prefix).equals(prefixString)) {  //while (!(hash.charAt(0)=='0' && hash.charAt(1)=='0' && hash.charAt(2)=='0' && hash.charAt(3)=='0')) {
	        nonce++;
	        hash = calculateBlockHash();
	    }
	    return hash;
	}
}
