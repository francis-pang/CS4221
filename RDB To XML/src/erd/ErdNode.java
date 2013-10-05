package erd;

import java.util.Iterator;
import java.util.Vector;

public abstract class ErdNode {
	
	//Attributes
	String tableName;
	String originalTableName;
	Vector<ErdNode> link;
	
	//Default constructor
	public ErdNode(String tableName, String originalTableName) {
		this.tableName = tableName;
		this.originalTableName = originalTableName;
	}
	
	//Method
	public void setTableName(String tableName){
		this.tableName = tableName;
	}
	
	public String getTableName(){
		return this.tableName;
	}
	
	public void setOriginalTableName(String originalTableName){
		this.originalTableName = originalTableName;
	}
	
	public String getOriginalTableName(){
		return originalTableName;
	}
	
	public void addLink(ErdNode erdNode){
		link.addElement(erdNode);
	};
	
	public Vector<ErdNode> getLinks(String tableName){
		return this.link;
	}
	
	public boolean doesLinkExists(String tableName){
		Iterator<ErdNode> linkIterator = link.iterator();
		
		if(!linkIterator.hasNext()){
			return false;
		}
		
		do{
			ErdNode iterErdNode = (ErdNode) linkIterator.next();
			
			String erdNodeTableName = iterErdNode.getTableName();
			
			if(erdNodeTableName == tableName){
				return true;
			}
		}while(linkIterator.hasNext());
		
		return false;
	}
}
