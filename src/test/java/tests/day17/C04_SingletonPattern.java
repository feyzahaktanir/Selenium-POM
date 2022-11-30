package tests.day17;

import org.testng.annotations.Test;
import utilities.Driver;


public class C04_SingletonPattern {
    @Test
    public void test1(){

        //singleton pattern: bir classtan birden fazla obje üretilmesine
        //izin vermeyen bir pattern olarak kabul görmüştür.

        //biz driver classını driver üretmek üzere kullanıyoruz.
        //ancak driver classında driver isminde bir intance variable da var
        //ve biz obje üreterekbu instance drivera ulaşabiliriz.

//        Driver driver1 = new Driver(); //Driver classını private yaptık
//
//        Driver driver2 = new Driver();
//
//        Driver driver3 = new Driver();

        //singletonpattern kabul görmüş bir patterndir
        //amaç bir classtan obje üretilmemesini sağlamaktır.
        //bunun için singleton patternde koruyacağımız classta
        //parametremiz bir constructor oluşturur ve
        //bu constructorı private yaparız
    }
}
