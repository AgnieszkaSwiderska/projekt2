package controller;

import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainWindowController {
	private Main main;
	private Stage primaryStage;
	private double pozX;
	private double pozY;

	
	@FXML private Group ryba1;
	@FXML private Group ryba2;
	@FXML private Polygon ogon1, ogon2;
	@FXML private Circle bubble;
	
	private Animation animation1, animation2;
	private Animation animation3;

	private Timer timer1, timer2;
	//private TranslateTransition ttb;

	public void setMain(Main main, Stage primaryStage){
		this.main=main;	
		this.primaryStage=primaryStage;
		
		
		primaryStage.setTitle("INU praca domowa nr 4 -- Agnieszka Œwiderska");
		
		timer1 = new Timer();
		MyTimerTask timer1_task = new MyTimerTask();
		timer1.schedule (timer1_task, 0, 2000);
		
		timer2 = new Timer();
		MyTimer2Task timer2_task = new MyTimer2Task();
		timer2.schedule (timer2_task, 2000, 100);
		
		/*
		TranslateTransition tt = new TranslateTransition();
		tt.setNode(bubble);
		tt.setDuration(Duration.seconds(2));
		tt.setByY(-500);
		tt.setCycleCount(Animation.INDEFINITE);
		animation3 = tt; */
		
		//pierwsza ryba
		Path animationPath1 = new Path();
		
		MoveTo moveTo = new MoveTo(-220,0);
		CubicCurveTo sineCurve1 = new CubicCurveTo(
				100, -50,   //1-szy punkt kontrolny
				100, 50,    //2-gi punkt kontrolny
				-200,200		//koniec
				);
		CubicCurveTo sineCurve2 = new CubicCurveTo(
				100, -50,   //1-szy punkt kontrolny
				100, 50,    //2-gi punkt kontrolny
				-220,0		//koniec
				);
		
		animationPath1.getElements().addAll(moveTo, sineCurve1, sineCurve2);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.seconds(20));
		pt.setPath(animationPath1);
		pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setInterpolator(Interpolator.LINEAR); 
		
			
		PauseTransition p1 = new PauseTransition();
		p1.setDuration(Duration.seconds(10));
		PauseTransition p2 = new PauseTransition();
		p2.setDuration(Duration.seconds(10));
		
		KeyFrame kf0 = new KeyFrame(
				Duration.seconds(0),   
				new KeyValue( ogon1.scaleYProperty(),0.6),
				new KeyValue( ogon1.scaleXProperty(),0.4),
				new KeyValue( ogon2.scaleYProperty(),0.9),
				new KeyValue( ogon2.scaleXProperty(),0.1)				
				);  //klatka kluczowa
		KeyFrame kf1 = new KeyFrame(
				Duration.seconds(2.5),   
				new KeyValue( ogon1.scaleYProperty(),0.9),
				new KeyValue( ogon1.scaleXProperty(),0.1),
				new KeyValue( ogon2.scaleYProperty(),0.6),
				new KeyValue( ogon2.scaleXProperty(),0.4)				
				);  //klatka kluczowa
		KeyFrame kf2 = new KeyFrame(
				Duration.seconds(5),   
				new KeyValue( ogon1.scaleYProperty(),0.6),
				new KeyValue( ogon1.scaleXProperty(),0.4),
				new KeyValue( ogon2.scaleYProperty(),0.9),
				new KeyValue( ogon2.scaleXProperty(),0.1)
				);  //klatka kluczowa
		
		KeyFrame kf3 = new KeyFrame(
				Duration.seconds(7.5),   
				new KeyValue( ogon1.scaleYProperty(),0.9),
				new KeyValue( ogon1.scaleXProperty(),0.1),
				new KeyValue( ogon2.scaleYProperty(),0.6),
				new KeyValue( ogon2.scaleXProperty(),0.4)
				);  //klatka kluczowa
		KeyFrame kf4 = new KeyFrame(
				Duration.seconds(10),   
				new KeyValue( ogon2.scaleYProperty(),0.9),
				new KeyValue( ogon2.scaleXProperty(),0.1),
				new KeyValue( ogon1.scaleYProperty(),0.6),
				new KeyValue( ogon1.scaleXProperty(),0.4)
				);  //klatka kluczowa
		KeyFrame kf5 = new KeyFrame(
				Duration.seconds(12.5),   
				new KeyValue( ogon1.scaleYProperty(),0.9),
				new KeyValue( ogon1.scaleXProperty(),0.1),
				new KeyValue( ogon2.scaleYProperty(),0.6),
				new KeyValue( ogon2.scaleXProperty(),0.4)
				);  //klatka kluczowa
		KeyFrame kf6 = new KeyFrame(
				Duration.seconds(15),  
				new KeyValue( ogon2.scaleYProperty(),0.9),
				new KeyValue( ogon2.scaleXProperty(),0.1),
				new KeyValue( ogon1.scaleYProperty(),0.6),
				new KeyValue( ogon1.scaleXProperty(),0.4)
				);  //klatka kluczowa		
		KeyFrame kf7 = new KeyFrame(
				Duration.seconds(17.5),   
				new KeyValue( ogon1.scaleYProperty(),0.9),
				new KeyValue( ogon1.scaleXProperty(),0.1),
				new KeyValue( ogon2.scaleYProperty(),0.6),
				new KeyValue( ogon2.scaleXProperty(),0.4)
				);  //klatka kluczowa
		KeyFrame kf8 = new KeyFrame(
				Duration.seconds(20),   
				new KeyValue( ogon2.scaleYProperty(),0.9),
				new KeyValue( ogon2.scaleXProperty(),0.1),
				new KeyValue( ogon1.scaleYProperty(),0.6),
				new KeyValue( ogon1.scaleXProperty(),0.4)
				);  //klatka kluczowa
		
		
		Timeline t1 = new Timeline(kf0,kf1,kf2,kf3,kf4,kf5,kf6,kf7,kf8);
		
		SequentialTransition seq1 = new SequentialTransition(p1,p2);
		ParallelTransition par1 = new ParallelTransition(ryba1,pt,seq1,t1);
		par1.setCycleCount(Animation.INDEFINITE);
		
		animation1 = par1;   //animacja 1-ej ryby


		///druga ryba
		Path animationPath2 = new Path();
		MoveTo moveTo2 = new MoveTo(110,100);
		CubicCurveTo sineCurve21 = new CubicCurveTo(
				 120, -50,   //1-szy punkt kontrolny
				470, 250,    //2-gi punkt kontrolny
				480, 100		//koniec
				);
		CubicCurveTo sineCurve22 = new CubicCurveTo(
				470, -50,   //1-szy punkt kontrolny
				120, 250,    //2-gi punkt kontrolny
				110,100		//koniec
				);
	
		animationPath2.getElements().addAll(moveTo2, sineCurve21, sineCurve22);
		
		PathTransition pt2 = new PathTransition();
		pt2.setNode(ryba2);
		pt2.setDuration(Duration.seconds(15));
		pt2.setPath(animationPath2);
		pt2.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		pt2.setInterpolator(Interpolator.LINEAR);  
		pt2.setCycleCount(Animation.INDEFINITE);

		animation2=pt2;  //animacja drugiej ryby
		
		animation1.play();
		animation2.play();
	}
	
	@FXML
	public void closeStage(){
		timer1.cancel();
		timer2.cancel();
		primaryStage.close();
	}
	
	class MyTimerTask extends TimerTask
	 {

		public void run()
		{
			//b¹belek startuje od rybki
			pozX = ryba1.getTranslateX();
			pozY = ryba1.getTranslateY();
		  
			bubble.setTranslateX(pozX);
			bubble.setTranslateY(pozY);
			
			bubble.setScaleX(0.4);
			bubble.setScaleY(0.4);
			//bubble.setVisible(true);
			
			/*ttb = new TranslateTransition();
			ttb.setNode(bubble);
			ttb.setDuration(Duration.seconds(1.5));
			ttb.setFromX(bubble.getLayoutX() + bubble.getTranslateX());
			ttb.setFromY(bubble.getLayoutY()+ bubble.getTranslateY());
			ttb.setByY(-50);
			//ttb.setCycleCount(Animation.INDEFINITE);
			animation3 = ttb; 
			animation3.play();*/
		}
	 }
	
	class MyTimer2Task extends TimerTask
	 {
		
		public void run()
		{
			//b¹belek porusza siê w górê i powiêksza siê nieznacznie
			double tr2Y = bubble.getTranslateY()-20;
		  
			bubble.setTranslateY(tr2Y);
		  
			bubble.setScaleX(bubble.getScaleX()+0.1);
			bubble.setScaleY(bubble.getScaleY()+0.1);
			bubble.setVisible(true);

		}
	 }
	
}
