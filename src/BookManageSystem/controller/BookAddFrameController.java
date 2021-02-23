package BookManageSystem.controller;

import BookManageSystem.beans.BookTypeBean;
import BookManageSystem.dao.BookDao;
import BookManageSystem.dao.BookTypeDao;
import BookManageSystem.tools.SimpleTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class BookAddFrameController {
    private SimpleTools simpleTools = new SimpleTools();

    @FXML
    private TextField bookAuthorTextField;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private TextField bookPriceTextField;

    @FXML
    private ComboBox<?> bookTypeComboBox;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private Button addButton;

    @FXML
    private Button resetButton;

    @FXML
    private TextField bookNameTextField;

    @FXML
    private TextArea bookDescriptionTextArea;

    /**
     * 初始化界面控件数据
     */
    public void initialize() {
        // 批量为按钮添加图标
        simpleTools.setLabeledImage(new Labeled[]{addButton, resetButton}, new String[]{"src/BookManageSystem/images/add.png",
                "src/BookManageSystem/images/reset.png"});
        // 查询所有图书类别的SQL语句
        String getBookTypeSQL = "select * from tb_booktype";
        // 获取所有图书类别的数据
        List bookTypeList = new BookTypeDao().getRecordsDataBySql(getBookTypeSQL);
        // 获取所有的图书类别名称
        String[] typeNames = new String[bookTypeList.size()];
        for (int i = 0; i < bookTypeList.size(); i++) {
            BookTypeBean bookTypeBean = (BookTypeBean) bookTypeList.get(i);
            typeNames[i] = bookTypeBean.getBookTypeName();
        }
        // 初始化下拉列表框的选项
        simpleTools.addComboBoxItems(bookTypeComboBox, typeNames);
    }

    // 【添加】按钮的事件监听器
    public void do_addButton_event(ActionEvent event) {
        // 获取用户输入的图书名称
        String name = bookNameTextField.getText();
        // 获取用户输入的图书作者
        String author = bookAuthorTextField.getText();
        // 获取用户选中的图书作者性别
        String sex = "";
        if (maleRadioButton.isSelected()) {
            sex = maleRadioButton.getText();
        } else if (femaleRadioButton.isSelected()) {
            sex = femaleRadioButton.getText();
        }
        // 获取用户输入的图书价格
        String price = bookPriceTextField.getText();
        // 获取用户选择的图书类别
        String type = (String) bookTypeComboBox.getSelectionModel().selectedItemProperty().getValue();
        // 获取用户输入的图书描述
        String description = bookDescriptionTextArea.getText();

        // 条件查询图书类别
        String bookTypeSQL = "select * from tb_booktype where btName='" + type + "';";
        List bookTypeList = new BookTypeDao().getRecordsDataBySql(bookTypeSQL);
        BookTypeBean bookTypeBean = (BookTypeBean) bookTypeList.get(0);
        // 获取图书类别的id号
        int bookTypeId = bookTypeBean.getBookTypeId();
        // 组装添加数据的SQL语句
        String sql =
                "insert into tb_book(bBookName, bAuthor, bSex, bPrice, bBookDescription, btId) values('" + name + "'," +
                        "'" + author + "','" + sex + "'," + price + ",'" + description + "'," + bookTypeId + ");";
        // 执行添加操作并获取返回结果
        boolean isOK = new BookDao().dataChange(sql);
        // 对结果进行判断
        if (isOK) {
            // 添加成功则重置用户输入并弹出提示框
            resetContent();
            simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "添加成功！");
        } else {
            // 添加失败也弹出提示框
            simpleTools.informationDialog(Alert.AlertType.ERROR, "提示", "错误", "添加失败！");
        }
    }

    // 【重置】按钮的事件监听器
    public void do_resetButton_event(ActionEvent event) {
        // 重置用户输入及选择
        resetContent();
    }

    /**
     * 重置文本框、单选按钮和下拉列表框
     */
    private void resetContent() {
        simpleTools.clearTextField(bookNameTextField, bookAuthorTextField, bookPriceTextField, bookDescriptionTextArea);
        simpleTools.clearSelectedRadioButton(maleRadioButton, femaleRadioButton);
        simpleTools.clearSelectedComboBox(bookTypeComboBox);
    }

}
