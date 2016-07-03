package thinkinjava.generics;

import java.util.*;

/**
 * Created by Bill on 2016/6/28.
 * Email androidBaoCP@163.com
 */
public class LostInformation {
    public static void main(String[] args){
        List<Forb> lists=new ArrayList<>();
        Map<Forb,Fnorkel> map=new HashMap<>();
        Quark<Fnorkel> quark=new Quark<>();
        Particle<Long,Double> particle=new Particle<>();
        System.out.println(Arrays.asList(lists.getClass().getTypeParameters()));
        System.out.println(Arrays.asList(map.getClass().getTypeParameters()));
        System.out.println(Arrays.asList(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.asList(particle.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(args));
    }
}
class Forb{}
class Fnorkel{}
class Quark<Q>{}
class Particle<POSITION,MOMENTUM>{}
