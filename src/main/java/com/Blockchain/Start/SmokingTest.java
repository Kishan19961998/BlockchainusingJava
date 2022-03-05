package com.Blockchain.Start;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmokingTest {
	
	@SuppressWarnings("unused")
	public void Blockchain() {
		
		BlockData newBlock;
		List<BlockData> blockchain = new ArrayList<>();
		
		
			newBlock = new BlockData("100 sent to Krish", "", new Date().getTime());
			//newBlock.setHash(newBlock.calculateBlockHash());
			//System.out.println("Hash before Mine -- "+ newBlock.getHash());			
			//System.out.println("after Moned : "+str);
			newBlock.setHash(newBlock.mineBlock(1));
			blockchain.add(newBlock);
		BlockData bd = blockchain.get(0);
		System.out.println("Hash -- "+bd.getHash()+"\nData -- "+bd.getData()+"\nNounce -- "+bd.getNonce()+"\nPrevious Hash -- "+bd.getPreviousHash()+"\nTime -- "+bd.getTimeStamp());
		
	}

}