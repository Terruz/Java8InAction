package lambdasinaction.chap1;

import java.util.Arrays;
import java.util.List;

public class PrettyPrintApple{

    public static void main(String ... args){

        List<Apple> inventory = Arrays.asList(new Apple(1,80,"green"),
                                              new Apple(2,155, "green"),
                                              new Apple(3,120, "red"),
                                              new Apple(4,130, "yellow"));	
        
        prettyPrintApple(inventory, new ColorApplePrint());
        prettyPrintApple(inventory, new ApplePrint());
        
        prettyPrintApple(inventory, new PrettyPrintInterface() {
			@Override
			public String print(Apple apple) {
				return "peso " + apple.getWeight() + " colore " + apple.getColor();
			}
		});
        
        prettyPrintApple(inventory, new PrettyPrintInterface() {});
        
    }
    
    /*
     * interfaccia funzionale
     */
    public interface PrettyPrintInterface {
    	 public default String print(Apple apple) {
			return apple.toString();
		}
    }
    
    public static void prettyPrintApple(List<Apple> list, PrettyPrintInterface printer)
    {
    	for (Apple apple : list) {
			System.out.println(printer.print(apple));
		}
    }
    
    public static class ColorApplePrint implements PrettyPrintInterface
    {

		@Override
		public String print(Apple apple) {
			return apple.getId() + ")" + apple.getColor();
		}
    	
    }
    
    public static class ApplePrint implements PrettyPrintInterface
    {

		@Override
		public String print(Apple apple) {
			return "mela " + apple.getColor() + ", peso " +apple.getWeight()  ;
		}
    	
    }
   

    public static class Apple {
    	private int id = 0;
        private int weight = 0;
        private String color = "";

        public Apple(int id, int weight, String color){
        	this.id = id;
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getId() {
			return id;
		}
        public void setId(int id) {
			this.id = id;
		}
        
        public String toString() {
            return "Apple{" +
                   "color='" + color + '\'' +
                   ", weight=" + weight +
                   '}';
        }
    }

}
