import javafx.geometry.*;
import java.util.ArrayList;
import java.util.Stack;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
public class Calc extends Application  
{
	TextField text;
	String textDisplay ="";
	boolean openBrakets = false;
	static boolean chek=false;
	ArrayList<String> input = new ArrayList<>();
	@Override
	public void start(Stage primaryStage)
	{	
		text=new TextField();
		text.setAlignment(Pos.TOP_RIGHT);
	//	TextField text2=new TextField();
		GridPane pane=new GridPane();
		pane.setHgap(2);
		pane.setVgap(2);
		Button backButton = new Button("\u2190");    
		Button bt1=new Button("1");
		Button bt2=new Button("2");
		Button bt3=new Button("3");
		Button bt4=new Button("4");
		Button bt5=new Button("5");
		Button bt6=new Button("6");
		Button bt7=new Button("7");
		Button bt8=new Button("8");
		Button bt9=new Button("9");
		Button bt0=new Button("0");
		Button bt=new Button(".");
		Button btq1=new Button("%");
		Button btq2=new Button("^");
		Button btMul=new Button("*");
		Button btDiv=new Button("/");
		Button btSubt=new Button("-");
		Button btAdd=new Button("+");
		Button btDel=new Button("Ac");
		Button btEqual=new Button("=");
		//Button btOn=new Button("On");
		//Button btOff=new Button("Off");
		/////////////////////        BINDING        ////////////////////////////////////////////////////////
		
		text.prefWidthProperty().bind(pane.widthProperty().divide(4));
	    text.prefHeightProperty().bind(pane.heightProperty().divide(12));
		bt0.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    bt0.prefHeightProperty().bind(pane.heightProperty().divide(4));
		bt1.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    bt1.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    bt2.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    bt2.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    bt3.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    bt3.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    bt4.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    bt4.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    bt5.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    bt5.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    bt6.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    bt6.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    bt7.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    bt7.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    bt8.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    bt8.prefHeightProperty().bind(pane.heightProperty().divide(4));
		bt9.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    bt9.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    btMul.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    btMul.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    btDiv.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    btDiv.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    btSubt.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    btSubt.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    btAdd.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    btAdd.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    btq1.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    btq1.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    btq2.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    btq2.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    bt.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    bt.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    btDel.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    btDel.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    btEqual.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    btEqual.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    backButton.prefWidthProperty().bind(pane.widthProperty().divide(5));
	    backButton.prefHeightProperty().bind(pane.heightProperty().divide(4));
	    
	    ////////////////////////////////////////////////////////////////////////////////////////////////////
	    
	   
	    //////////////////////////////      STYLE       //////////////////////////////////////////////
	    
	    pane.setStyle( "-fx-font-size:25; -fx-background-color: black; -fx-color:#222222;"
	    		+ "-fx-border-color:#00656e; -fx-border-width:5");
	    btAdd.setStyle("-fx-background-color:#1976d9");
	    btDiv.setStyle("-fx-background-color:#1976d9");
	    btMul.setStyle("-fx-background-color:#1976d9");
	    btSubt.setStyle("-fx-background-color:#1976d9");
	    btEqual.setStyle("-fx-background-color:#aaaaaa");
	    ///////////////////////////////////////////////////////////////////////////////////////
	    
	    text.setEditable(false);
	    pane.add(text,0,0,5,1);
	  //  pane.add(text2,1,0,5,1);
		pane.addRow(1, bt7,bt8,bt9,btDel,backButton);
		pane.addRow(2, bt4,bt5,bt6,btDiv,btMul);
		pane.addRow(3, bt1,bt2,bt3,btSubt,btAdd);
		pane.addRow(4, bt0,bt,btq1,btq2,btEqual);
		//pane.add(text2,5,0,5,1);
		/////////////////////      ACTINOS      ////////////////////////////////
		
		btDel.setOnAction(e -> {
			try{
            text.clear();
            input.clear();
            textDisplay="";
           		} 
			 catch(Exception x)
            {
				 text.setText("error");
            }

        });
		backButton.setOnAction(e -> {
			try{
            if (!textDisplay.isEmpty() ){
                text.setText(textDisplay.substring(0, textDisplay.length() - 1));
                textDisplay= textDisplay.substring(0, textDisplay.length() - 1);
                input.remove(input.size()-1);
                
            }
			}

            catch(Exception x)
            {
            }

            
        });
		bt0.setOnAction(e->{
		
			try{
			 char ch = ' ';
             if (!textDisplay.equals("")) {
                 ch = textDisplay.charAt(textDisplay.length() - 1);
             }
             if ((ch != ')' )) {

                 textDisplay += "0";
                 text.setText(textDisplay);
                 
             }
             	input.add("0");
             }
              catch(Exception h)
             {
             }
			
		});
		bt1.setOnAction(e->{
			
			try{
				 char ch = ' ';
	             if (!textDisplay.equals("")) {
	                 ch = textDisplay.charAt(textDisplay.length() - 1);
	             }
	             if ((ch != ')' )) {

	                 textDisplay += "1";
	                 text.setText(textDisplay);

	             }
	             input.add("1");
	             }
	              catch(Exception h)
	             {
	             }

		});
		bt2.setOnAction(e->{
		
			try{
				 char ch = ' ';
	             if (!textDisplay.equals("")) {
	                 ch = textDisplay.charAt(textDisplay.length() - 1);
	             }
	             if ((ch != ')' )) {

	                 textDisplay += "2";
	                 text.setText(textDisplay);

	             }
	             input.add("2");
	             }
	              catch(Exception h)
	             {
	             }

		});
		bt3.setOnAction(e->{
		
			try{
				 char ch = ' ';
	             if (!textDisplay.equals("")) {
	                 ch = textDisplay.charAt(textDisplay.length() - 1);
	             }
	             if ((ch != ')' )) {

	                 textDisplay += "3";
	                 text.setText(textDisplay);

	             }
	             input.add("3");
	             }
	              catch(Exception h)
	             {
	             }

		});
		bt4.setOnAction(e->{
			
			try{
				 char ch = ' ';
	             if (!textDisplay.equals("")) {
	                 ch = textDisplay.charAt(textDisplay.length() - 1);
	             }
	             if ((ch != ')' )) {

	                 textDisplay += "4";
	                 text.setText(textDisplay);

	             }
	             input.add("4");
	             }
	              catch(Exception h)
	             {
	             }

		});
		bt5.setOnAction(e->{
		
			try{
				 char ch = ' ';
	             if (!textDisplay.equals("")) {
	                 ch = textDisplay.charAt(textDisplay.length() - 1);
	             }
	             if ((ch != ')' )) {

	                 textDisplay += "5";
	                 text.setText(textDisplay);

	             }
	             input.add("5");
	             }
	              catch(Exception h)
	             {
	             }

		});
		bt6.setOnAction(e->{
		
			try{
				 char ch = ' ';
	             if (!textDisplay.equals("")) {
	                 ch = textDisplay.charAt(textDisplay.length() - 1);
	             }
	             if ((ch != ')' )) {

	                 textDisplay += "6";
	                 text.setText(textDisplay);

	             }
	             input.add("6");
	             }
	              catch(Exception h)
	             {
	             }

		});
		bt7.setOnAction(e->{
			
			try{
				 char ch = ' ';
	             if (!textDisplay.equals("")) {
	                 ch = textDisplay.charAt(textDisplay.length() - 1);
	             }
	             if ((ch != ')' )) {

	                 textDisplay += "7";
	                 text.setText(textDisplay);

	             }
	             input.add("7");
	             }
	              catch(Exception h)
	             {
	             }

		});
		bt8.setOnAction(e->{
			
			try{
				 char ch = ' ';
	             if (!textDisplay.equals("")) {
	                 ch = textDisplay.charAt(textDisplay.length() - 1);
	             }
	             if ((ch != ')' )) {

	                 textDisplay += "8";
	                 text.setText(textDisplay);

	             }
	             input.add("8");
	             }
	              catch(Exception h)
	             {
	             }

		});
		bt9.setOnAction(e->{
			
			try{
				 char ch = ' ';
	             if (!textDisplay.equals("")) {
	                 ch = textDisplay.charAt(textDisplay.length() - 1);
	             }
	             if ((ch != ')' )) {

	                 textDisplay += "9";
	                 text.setText(textDisplay);

	             }
	             input.add("9");
	             }
	              catch(Exception h)
	             {
	             }

		});
		bt.setOnAction(e->{
			try{
                char ch = textDisplay.charAt(textDisplay.length() - 1);
                if (Character.isDigit(ch) || ch == ')') {
                    textDisplay += ".";
                    text.setText(textDisplay);
                   
                }
                input.add(".");
             }
                 catch(Exception h)
                {
                	 
                }

		});
		btq1.setOnAction(e->{
			try{
                char ch = textDisplay.charAt(textDisplay.length() - 1);
                if (Character.isDigit(ch) || ch == ')') {
                    textDisplay += "%";
                    text.setText(textDisplay);
                   
                }
                input.add("%");
             }
                 catch(Exception h)
                {
                	 
                }

		});        
		btq2.setOnAction(e->{
			try{
                char ch = textDisplay.charAt(textDisplay.length() - 1);
                if (Character.isDigit(ch) || ch == ')') {
                    textDisplay += "^";
                    text.setText(textDisplay);
                   
                }
                input.add("^");
             }
                 catch(Exception h)
                {
                	 
                }

		});
		btDiv.setOnAction(e->{
			try{
                char ch = textDisplay.charAt(textDisplay.length() - 1);
                if (Character.isDigit(ch) || ch == ')') {
                    textDisplay += "/";
                    text.setText(textDisplay);
                   
                }
                input.add("/");
             }
                 catch(Exception h)
                {
                	 
                }

		});
		btMul.setOnAction(e->{
		   
			 try{
	                char ch = textDisplay.charAt(textDisplay.length() - 1);
	                if (Character.isDigit(ch) || ch == ')') {
	                    textDisplay += "*";
	                    text.setText(textDisplay);
	                   
	                }
	                input.add("*");
	             }
	                 catch(Exception h)
	                {
	                	 
	                }
	            

		});
		btSubt.setOnAction(e->{
				
			try{
                char ch = textDisplay.charAt(textDisplay.length() - 1);
                if (Character.isDigit(ch) || ch == ')') {
                    textDisplay += "-";
                    text.setText(textDisplay);
                   
                }
                input.add("-");
             }
                 catch(Exception h)
                {
                	 
                } 
         

		});
		btAdd.setOnAction(e->{
					try{
                char ch = textDisplay.charAt(textDisplay.length() - 1);
                if (Character.isDigit(ch) || ch == ')') {
                    textDisplay += "+";
                    text.setText(textDisplay);
                   
                }
                input.add("+");
             }
                 catch(Exception h)
                {
                	 
                }

		});
		btEqual.setOnAction(e->
		{
		String s=pro();
		text.setText(s);
		input.clear();
		textDisplay="";
		}
		);
		
		///////////////k/////////////////////////////////////////////////////
	    
		Scene scen=new Scene(pane);
        primaryStage.setTitle("calculator");
		primaryStage.setScene(scen);
		primaryStage.show();
	}
	
String pro()
{
	
String ss=null;
String k[];
ArrayList<Double> numss=new ArrayList<>();
ArrayList<String> oper=new ArrayList<>();
input.add("&");
if(input.size()!=0)
{
 k=new String[input.size()];
}
else
{
	k=null;
}
for(int h=0;h<input.size();h++)
{	
	k[h]=input.get(h);
}
String s2 ="";
for(int p=0;p<k.length;p++)
{
	if(k[p]=="+" ||k[p]=="%" ||k[p]=="^" ||k[p]=="-" || k[p]=="/" ||k[p]=="*" || k[p]=="&")
	{	
		numss.add(Double.parseDouble(s2));
		oper.add(k[p]);
		s2="";
	}
	else 	
	{
		s2+=k[p];
	}
}
for(int kk=0;kk<oper.size();kk++)
{
	if(oper.get(kk)=="%")
	{
		numss.set(kk,numss.get(kk)%numss.get(kk+1));
		for(int a=kk+1;a<numss.size()-1;a++)
		{
	numss.set(a,numss.get(a+1));
	
}
oper.remove(kk);	//numss.set(kk,0.0);
}
	ss=Double.toString(numss.get(kk));
}
for(int kk=0;kk<oper.size();kk++)
{
if(oper.get(kk)=="^")
	{
		numss.set(kk,Math.pow(numss.get(kk),numss.get(kk+1)));
		for(int a=kk+1;a<numss.size()-1;a++)
		{
			numss.set(a,numss.get(a+1));	
		}
		oper.remove(kk);
	}
	ss=Double.toString(numss.get(kk));
}
for(int kk=0;kk<oper.size();kk++)
{
	if(oper.get(kk)=="*")
	{
		numss.set(kk,numss.get(kk)*numss.get(kk+1));
		for(int a=kk+1;a<numss.size()-1;a++)
		{
			numss.set(a,numss.get(a+1));
		}
oper.remove(kk);	//numss.set(kk,0.0);
		//ss=Double.toString(numss.get(kk));
	}
	ss=Double.toString(numss.get(kk));
}
for(int kk=0;kk<oper.size();kk++)
{
	if(oper.get(kk)=="/")
	{
		numss.set(kk,numss.get(kk)/numss.get(kk+1));
		for(int a=kk+1;a<numss.size()-1;a++)
		{
			numss.set(a,numss.get(a+1));	
		}
		oper.remove(kk);
	}
	ss=Double.toString(numss.get(kk));
}
String j[]=new String[oper.size()];
for(int o=0;o<j.length;o++)
{
	j[o]=oper.get(o);	
}

for(int i=0;i<j.length;i++)
{
	if( j[i]=="+")
	{
		numss.set(i+1,numss.get(i)+numss.get(i+1));
		ss=Double.toString(numss.get(i+1));
	}
	if( j[i]=="-")
	{
		numss.set(i+1,numss.get(i)-numss.get(i+1));
		ss=Double.toString(numss.get(i+1));
	}
	}
	return ss;
}
	 	public static void main(String[] args)
	{ launch(args); }
	
}
