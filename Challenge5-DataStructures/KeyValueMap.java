//UIUC CS125 FALL 2014 MP. File: KeyValueMap.java, CS125 Project: Challenge5-DataStructures, Version: 2015-10-10T22:44:36-0500.940130950
/**
 * @author qilezhi2
*/
import java.awt.Color;

public class KeyValueMap { // aka Dictionary or Map
	
	private String[] keyArray = new String[0];
	private Color[] valueArray = new Color[0];

	/**
	 * Adds a key and value. If the key already exists, it replaces the original
	 * entry.
	 */
	public void add(String key, Color value) {
		
		boolean doesExist=false;
		for (int i=0; i<this.keyArray.length; i++) {
			// If the key already exists, it replaces the original one.
			if (this.keyArray[i].equalsIgnoreCase(key)) { 
				this.valueArray[i]=value;
				doesExist=true;
			}
		}
		
		// If the key doesn't exist
		if (! doesExist) {
			String[] keyOld = this.keyArray;
			Color[] valueOld = this.valueArray;
			this.keyArray = new String[keyOld.length+1]; // create new arrays
			this.valueArray = new Color[valueOld.length+1];
			for (int i = 0; i < this.keyArray.length-1; i++) {
				this.keyArray[i] = keyOld[i];
				this.valueArray[i] = valueOld[i];
			}
			this.keyArray[this.keyArray.length-1] = key.toUpperCase();
			this.valueArray[this.keyArray.length-1] = value;
		}
	}

	/**
	 * Returns particular Color object previously added to this map.
	 */
	public Color find(String key) {
		for (int i=0; i<this.keyArray.length; i++) {
			if (this.keyArray[i].equalsIgnoreCase(key)) return this.valueArray[i]; 
		}
		return null;
	}

	/**
	 * Returns true if the key exists in this map.
	 */
	public boolean exists(String key) {
		for (int i=0; i<this.keyArray.length; i++) {
			if (this.keyArray[i].equalsIgnoreCase(key)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes the key (and the color) from this map.
	 */
	public void remove(String key) {
		for (int i=0; i<this.keyArray.length; i++) {
			if (this.keyArray[i].equalsIgnoreCase(key)) { // find key at the i-th position
				String[] keyOld = this.keyArray;
				Color[] valueOld = this.valueArray;
				this.keyArray = new String[keyOld.length-1]; // create new arrays
				this.valueArray = new Color[valueOld.length-1];
				
				for (int j = 0; j < i; j++) {
					this.keyArray[j] = keyOld[j];
					this.valueArray[j] = valueOld[j];
				}
				
				for (int j = i; j < this.keyArray.length; j++) {
					this.keyArray[j] = keyOld[j+1];
					this.valueArray[j] = valueOld[j+1];
				}
			}
		}
	}

}
