package businesslogic.bl.availableroombl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;

public class mytest {
	public static void main(String[] args) {
		AvailableRoom availableRoom = new AvailableRoom();
		ArrayList<AvailableRoomInfoVO> preRoomInfo = availableRoom.getAvailableRoomInfo("000005");
		availableRoom.setBestPrice("000005", 0.8);
//		ArrayList<AvailableRoomInfoVO> roomInfo = availableRoom.getAvailableRoomInfo("000005");
		// 第三个参数为允许误差
	}
}
