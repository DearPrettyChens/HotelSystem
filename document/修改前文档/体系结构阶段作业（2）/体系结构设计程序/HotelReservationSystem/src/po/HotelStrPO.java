package po;

import java.io.Serializable;
import java.util.ArrayList;

import common.Strategy;
/**
 * 传递所有的酒店营销策略
 * @author CLL
<<<<<<< HEAD
 * @version1.0
=======
 *
>>>>>>> refs/remotes/origin/cyfBranch
 */
public class HotelStrPO implements Serializable{
	private ArrayList<Strategy> strategies;
	
	public HotelStrPO(ArrayList<Strategy> strategies){
		this.setStrategies(strategies);
	}

	public ArrayList<Strategy> getStrategies() {
		return strategies;
	}

	public void setStrategies(ArrayList<Strategy> strategies) {
		this.strategies = strategies;
	}
}
