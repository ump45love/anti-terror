package Type;

import org.bukkit.Material;


public class BanBlockType {
	Material m;
	int number;
	
	public BanBlockType(){
		m = null;
		number = 0;
	}
	public BanBlockType(String name,int number){
		this.m =Material.getMaterial(name);
		this.number = number;
	}
	
	public BanBlockType(Material m,int number){
		this.m =m;
		this.number = number;
	}
	
	public String getBanBlockName() {
		return m.name();
	}
	
	public int getExp() {
		return number;
	}
	
	public void setExp(int exp) {
		number = exp;
	}
	 @Override
		public boolean equals(Object object) {
		 BanBlockType product = (BanBlockType) object;
			if ((product.m.getId() == this.m.getId()) && (this.number <= product.number)) {
			return true;
			}
			return false;
			}
	 
	 
}
