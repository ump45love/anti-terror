package Type;

import org.bukkit.Material;


public class BanBlockType {
	Material m;
	float number;
	
	public BanBlockType(){
		m = null;
		number = 0;
	}
	public BanBlockType(String name,float number){
		this.m =Material.getMaterial(name);
		this.number = number;
	}
	
	public BanBlockType(Material m,float number){
		this.m =m;
		this.number = number;
	}
	
	 @Override
		public boolean equals(Object object) {
		 BanBlockType product = (BanBlockType) object;
			if ((product.m == this.m) && (this.number <= product.number)) {
			return true;
			}
			return false;
			}
}
