package controller;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Customer;//Importa a classe Customer do pacote model, que é a classe dos tipos da tabela.

public class Controller13 implements Initializable {

    //Id da tabela
    @FXML
    private TableView<Customer> tableview;
    
    //Colunas da tabela
    @FXML
    private TableColumn<Customer, String> nameC;
    @FXML
    private TableColumn<Customer, Integer> ageC;
    @FXML
    private TableColumn<Customer, String> numberC;


    @FXML
    Button buttonAdd;
    @FXML
    Button buttonRemove;
    @FXML
    Button buttonUpdate;
    @FXML
    TextField tfname;
    @FXML
    TextField tfage;
    @FXML
    TextField tfnumber;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameC.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));//Aqui é onde se define qual atributo da classe Customer será exibido na coluna nameColumn.
        ageC.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("age"));//Aqui é onde se define qual atributo da classe Customer será exibido na coluna ageColumn.
        numberC.setCellValueFactory(new PropertyValueFactory<Customer,String>("number"));//Aqui é onde se define qual atributo da classe Customer será exibido na coluna numberColumn.
    }

    public void add() {
        Customer customer = new Customer(tfname.getText(), Integer.parseInt(tfage.getText()));//Cria um objeto do tipo Customer com os dados digitados nos campos de texto.
        tableview.getItems().add(customer);//Adiciona o objeto criado na tabela.
        tfname.setText("");//Limpa o campo de texto.
        tfage.setText("");//Limpa o campo de texto.
        tfnumber.setText("");//Limpa o campo de texto.
    }

    public void remove() {
        int index = tableview.getSelectionModel().getSelectedIndex();//Pega o índice da linha selecionada.
        tableview.getItems().remove(index);//Remove a linha selecionada.
    }

    public void update(ActionEvent event){
        ObservableList<Customer> currentTableData = tableview.getItems();//Pega a lista de objetos Customer da tabela.
        int currentCustomerID = Integer.parseInt(tfnumber.getText());//Pega o número do objeto Customer que está sendo editado.

        for(Customer customer : currentTableData){//Percorre a lista de objetos Customer da tabela.
            if(customer.getNumber() == currentCustomerID){//Se o número do objeto Customer for igual ao número do objeto Customer que está sendo editado, atualiza os dados do objeto Customer.
                customer.setName(tfname.getText());//Atualiza o nome do objeto Customer.
                customer.setAge(Integer.parseInt(tfage.getText()));//Atualiza a idade do objeto Customer.
                customer.setNumber(Integer.parseInt(tfnumber.getText()));//Atualiza o número do objeto Customer.

                tableview.setItems(currentTableData);
                tableview.refresh();//Atualiza a lista de objetos Customer da tabela.

                tfname.setText("");//Limpa o campo de texto.
                tfage.setText("");//Limpa o campo de texto.
                tfnumber.setText("");//Limpa o campo de texto.

                break;//Para o loop.
            }
        }

    }

    public void rowClicked(MouseEvent event){
        Customer customer = tableview.getSelectionModel().getSelectedItem();//Pega o objeto Customer da linha selecionada.
        if(customer != null){//Se o objeto Customer não for nulo, preenche os campos de texto com os dados do objeto Customer.
            tfname.setText(customer.getName());//Preenche o campo de texto com o nome do objeto Customer.
            tfage.setText(String.valueOf(customer.getAge()));//Preenche o campo de texto com a idade do objeto Customer.
            tfnumber.setText(Integer.toString(customer.getNumber()));//Preenche o campo de texto com o número do objeto Customer.
        }
    }
}
