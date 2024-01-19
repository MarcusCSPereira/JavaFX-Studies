import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    
    //Group root = new Group();Declaro aqui caso eu preciso disso para adicionar novos Nodes a minha Scene, pelo método addNode;
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        //Criando um Objeto do tipo Group, que é um tipo de Node, e é o root da nossa Scene
        Group root = new Group();
        Scene scene = new Scene(root,600,600,Color.AQUA);

        //Criando um Objeto do tipo Text
        Text text = new Text();
        //O texto do nosso obejto, isso pode ser passado direto pelo construtor
        text.setText("Eita pouhaaa");
        //Declara posições de X e Y em relação ao root do texto
        text.setX(50);
        text.setY(50);
        //Setando a fonte do texto, ele necesita receber o objeto do tipo Font, e pode ser passado de diveeersas formas.
        text.setFont(Font.font("Verdena",50));
        //Modifica a cor do testo e recebe um Objeto do tipo Paint, e Color é uma subclasse de Paint, por isso posso usa-lá.
        text.setFill(Color.RED);

        //O text é um tipo de node, logo precisamos adicionar ele ao nosso root, que já está associado a nossa Scene.
        addNode(root,text);

        //A maioria dos métodos abaixo pode ser passado pelo própio contrustor.
        Line line = new Line();
        //Declara a posição de X e Y do inicio da linha
        line.setStartX(400);
        line.setStartY(400);
        //Declara a posição de X e Y do fim da linha
        line.setEndX(600);
        line.setEndY(600);
        //Modifica a cor da linha
        line.setStroke(Color.RED);
        //Modifica a largura da linha
        line.setStrokeWidth(5);
        //Modifica a opacidade da linha
        line.setOpacity(0.5);
        //Rotaciona a linha em 45 graus
        line.setRotate(0);
        //Adiciona a linha ao root
        addNode(root, line);

        //Criando um Objeto do tipo Rectangle
        Rectangle rectangle = new Rectangle();//A maioria dos métodos abaixo pode ser passado pelo própio contrustor.

        //Declara a posição de X e Y do inicio do retangulo
        rectangle.setX(50);
        rectangle.setY(100);
        //Declara a largura e altura do retangulo
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        //Modifica a cor do retangulo
        rectangle.setFill(Color.PINK);
        //Modifica a opacidade do retangulo
        rectangle.setOpacity(0.9);
        //Aumenta a largura da borda do retangulo
        rectangle.setStrokeWidth(5);
        //Modifica a cor da borda do retangulo
        rectangle.setStroke(Color.BLACK);


        //Adiciona o retangulo ao root
        addNode(root, rectangle);

        //Criando um Objeto do tipo Polygon
        Polygon triangle = new Polygon();//A maioria dos métodos abaixo pode ser passado pelo própio contrustor.

        //Adiciona os pontos do triangulo
        triangle.getPoints().setAll(
            200.0, 200.0,
                        400.0, 200.0,
                        300.0, 400.0
        );
        //Modifica a cor do triangulo
        triangle.setFill(Color.YELLOW);
        //Modifica a opacidade do triangulo
        triangle.setOpacity(0.9);
        //Aumenta a largura da borda do triangulo
        triangle.setStrokeWidth(5);
        //Modifica a cor da borda do triangulo
        triangle.setStroke(Color.BLACK);

        //Adiciona o triangulo ao root
        addNode(root, triangle);

        //Criando um Objeto do tipo Circle
        Circle circle = new Circle();//A maioria dos métodos abaixo pode ser passado pelo própio contrustor.

        //Declara a posição de X e Y do centro do circulo
        circle.setCenterX(200);
        circle.setCenterY(450);
        //Declara o raio do circulo
        circle.setRadius(100);
        //Modifica a cor do circulo
        circle.setFill(Color.LIMEGREEN);
        //Modifica a opacidade do circulo
        circle.setOpacity(0.9);
        //Aumenta a largura da borda do circulo
        circle.setStrokeWidth(5);
        //Modifica a cor da borda do circulo
        circle.setStroke(Color.BLACK);
        
        //Adiciona o circulo ao root
        addNode(root, circle);

        //Criando um objeto do tipo ImageView, que é um tipo de Node
        ImageView imageView = new ImageView("assets/pizza_slice.png");
        //Modifica a posição de X e Y da imagem
        imageView.setX(450);
        imageView.setY(100);
        //Modifica a largura e altura da imagem
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        //Adiciona a imagem ao root
        addNode(root, imageView);

        //Adicionando uma icone a nossa janela
        Image icon = new Image("assets/teste.png");
        primaryStage.getIcons().add(icon);

        primaryStage.setTitle("Aula_02: Trabalhando com Scene");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void addNode(Parent root,Node node){
        if(root instanceof Group){
            ((Group)root).getChildren().add(node);
        }
    }

}
