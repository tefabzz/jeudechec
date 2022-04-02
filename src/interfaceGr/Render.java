package interfaceGr;

import com.sun.prism.shader.DrawRoundRect_Color_AlphaTest_Loader;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pieces.*;

import javax.sound.midi.Soundbank;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Render  extends Application {
    Echiquier echiquier = new Echiquier();



    @Override
    public void start(Stage stage) throws Exception {
//

        //Création de l'échiquier :
        Group root = new Group();
        Canvas canvas = new Canvas(750, 750);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);

        stage.setTitle("Chess Game");
        scene.setFill(Color.WHITE);
        GraphicsContext gc = canvas.getGraphicsContext2D();


       draw(gc);

        // création du zone de message
        Group sign = new Group();
        Rectangle panel = new Rectangle(0, 600, 512, 50);
        panel.setFill(Color.BLACK);
        sign.getChildren().add(panel);
        root.getChildren().add(sign);
        addButton(root);


        // AFFICHAGE DES NOMS DES PIECES, LEURS COORDONNEES AINSI QUE LEURS DEPLACEMENTS POSSIBLES
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEventpositon) {
                if (mouseEventpositon.getSceneX() <= 512 && mouseEventpositon.getSceneX() >= 0
                        && mouseEventpositon.getSceneY() <= 512 && mouseEventpositon.getSceneY() >= 0) {
                    int x;
                    int y;
                    double xm = mouseEventpositon.getSceneX();
                    double ym = mouseEventpositon.getSceneY();
                    x = (int) xm / 64;
                    y = (int) ym / 64;


                    System.out.println(echiquier.pieceAtPos(x*64,y*64));
                    System.out.println();

                    System.out.println("La postion de la pièce est  [" + y + "]" + "[" + x + "]");
                    Piece p = echiquier.pieceAtPos(x*64,y*64);
                    System.out.println("la pièce est [ "+ p.getName() +"]");
                    ArrayList<Position> positions = p.possibleMove(x,y);
                    for (Position pos : positions){
                        System.out.println("ses deplacements possibles sont ["+ pos.getX() + "]" + "[" + pos.getY() + "]");
                        int i = pos.getX();
                        int j = pos.getY();

                        Rectangle panel2 = new Rectangle(i,j,64,64);
                        panel2.setFill(Color.GREEN);
                        sign.getChildren().add(panel2);

                    }

                    }

                }

        });


        stage.setScene(scene);
        stage.show();

    }
    private void draw(GraphicsContext gc){
        // ECHIQUIER:
        boolean estBlanc = false;

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {

                if (estBlanc) {
                    gc.setFill(Color.BROWN);
                } else {
                    gc.setFill(Color.WHITE.darker());
                }

                gc.fillRect(x * 64, y * 64, 64, 64);
                estBlanc = !estBlanc;
            }
            estBlanc = !estBlanc;
        }
        ArrayList<Piece> blanc = echiquier.getBlancs();
        for (Piece piece : blanc){
            gc.drawImage(piece.getSkin(), piece.getX(), piece.getY(),64,64);
        }
        ArrayList<Piece> noire = echiquier.getNoires();
        for (Piece piece : noire){
            gc.drawImage(piece.getSkin(), piece.getX(), piece.getY(),64,64);
        }


    }
        // les boutons Menu et Help
    private void addButton(Group root){
        Button button1 = new Button("Menu");
        Button button2 = new Button("Help");


        root.getChildren().add(button1);
        button1.setTranslateX(700);
        button1.setTranslateY(0);
        root.getChildren().add(button2);
        button2.setTranslateX(650);
        button2.setTranslateY(0);


        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("click");
            }
        });
        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("click");
            }
        });
    }
}

//        private class Mytimer extends AnimationTimer{
//            private long prevTime = 0;
//
//            @Override
//            public void handle(long now) {
//                long dt = now - prevTime;
//                if (dt > 15e6){
//                    prevTime= now;
//                }
//                System.out.println();
//
//            }
//
//        }



