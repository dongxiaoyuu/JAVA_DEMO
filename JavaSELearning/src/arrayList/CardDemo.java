package arrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA
 * Description:接顺序表--扑克牌练习
 * User:dxy
 * Date:2022-03-12
 * Time:10:36
 */
class Card{
    private String  suit;
    private int rank;

    public Card(String  suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return
                 suit + rank+" ";
    }
}

public class CardDemo {
    private static final String [] SUITS={"红桃","黑桃","方片","梅花"};
    //买牌
    public static List<Card> buyCard(){
        List<Card> cards=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <=13; j++) {
                String suit=SUITS[i];
                int rank=j;
                Card card=new Card(suit,rank);
                cards.add(card);
            }
        }
        return cards;
    }
    //洗牌
    public static void shuffle(List<Card> cards){
        Random random=new Random();

        for (int i = cards.size()-1; i >0 ; i--) {
            int index=random.nextInt(i);
            //这里，cards不是一个数组，是一个对象所以获取下标用get，赋值用set
            Card tmp=cards.get(i);
            cards.set(i,cards.get(index));
            cards.set(index,tmp);
        }
    }
    public static void main(String[] args) {

        List<Card> cardList=buyCard();
        shuffle(cardList);
        System.out.println("洗牌"+cardList);

        List<List<Card>> hands=new ArrayList<>();//有点像二维数组的感觉
        List<Card> hand1=new ArrayList<>();
        List<Card> hand2=new ArrayList<>();
        List<Card> hand3=new ArrayList<>();

        hands.add(hand1);
        hands.add(hand2);
        hands.add(hand3);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card= cardList.remove(0);//每次删除0下标的牌
                hands.get(j).add(card);
            }
        }
        System.out.println("NO.1"+hand1);
        System.out.println("NO.2"+hand2);
        System.out.println("NO.3"+hand3);
        System.out.println("剩余"+cardList);
    }

}
