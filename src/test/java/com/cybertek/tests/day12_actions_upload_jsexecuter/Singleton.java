package com.cybertek.tests.day12_actions_upload_jsexecuter;

public class Singleton {

    //Create private constructor
    private Singleton(){}

    //By making the String word Private,
    //we will ensure we create access only through our getter

    private static String word;

    //we allow user to access to 'word' in the way we want them to have
    public static String getWord(){
        if(word==null){
            System.out.println("First time call. Word object is null. Assigning value to it now...");
        word="something";
        }else{
            System.out.println("word already has a value");
        }
        return word;
    }

}
