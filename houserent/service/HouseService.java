package com.hsp.houserent.service;

import com.hsp.houserent.domain.House;

/**
 * HouseService.java<=>类 [业务层]
 * //定义House[] ,保存House对象
 * 1. 响应HouseView的调用
 * 2. 完成对房屋信息的各种操作(增删改查c[create]r[read]u[update]d[delete])
 */
public class HouseService {
    private House[] houses;
    private int houseNums = 1;
    private int idCounter = 1;

    public HouseService(int size){
        houses = new House[size];
        houses[0] = new House(1,"jack","112","hello street",2000,"not rent");
    }

    public House find(int findId){
        for(int i=0;i<houseNums;i++){
            if(houses[i].getId() == findId){
                return houses[i];
            }
        }
        return null;
    }
    public boolean del(int delId){
//        check whether the house exists

        int index = -1;
        for(int i=0;i<houseNums;i++){
            if(delId == houses[i].getId()){
                index = i;
            }
        }

        if(index == -1){ // cannot find house with id delId
            return false;
        }
//        if find the house, delete
        for(int i=index;i<houseNums-1;i++){
            houses[i] = houses[i+1];

        }
        houses[--houseNums] = null;
        return true;


    }

    public boolean add(House newHouse){
        if(houseNums == houses.length){
//            cannot add
            System.out.println("Full, cannot add");
            return false;
        }
        houses[houseNums] = newHouse;
        houseNums++;
        idCounter++;
        newHouse.setId(idCounter);
        return true;


    }
    public House[] list(){
        return houses;
    }
}
