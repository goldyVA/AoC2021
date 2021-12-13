
public class Octupus 
{
	private int energyLevel;
	private boolean hasFlashed;
	
	public Octupus(int eL)
	{
		energyLevel = eL;
		hasFlashed = false;
	}
	
	public int getEnergyLevel()
	{
		return energyLevel;
	}
	
	public boolean hasFlashed()
	{
		return hasFlashed;
	}
	
	public void increaseEnergy()
	{
		energyLevel++;
	}
	
	public void setFlash(boolean f)
	{
		if(f)
			hasFlashed = true;
		else
			hasFlashed = false;
	}
	
	public void reset()
	{
		energyLevel = 0;
		hasFlashed = false;
	}
	
}
