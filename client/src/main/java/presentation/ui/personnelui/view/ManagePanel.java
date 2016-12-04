package presentation.ui.personnelui.view;

/**
 * 为了方便界面逻辑处理，让ManageHotelWorker和ManageWebMarketMan都来实现这个接口
 * 第一个是转换成搜索界面
 * 第二个是转换成添加人员界面
 * @author csy
 *
 */
public interface ManagePanel {
      public void changeToSearchPanel();
      public void changeToAddPanel();
}
