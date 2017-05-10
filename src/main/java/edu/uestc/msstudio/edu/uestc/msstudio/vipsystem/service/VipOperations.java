package edu.uestc.msstudio.edu.uestc.msstudio.vipsystem.service;

import edu.uestc.msstudio.edu.uestc.msstudio.vipsystem.model.VIPRank;

/**
 * Created by MT on 2017/5/7.
 */
public class VipOperations {
    public static Long discount(Float originCount, VIPRank rank) {
        float about = 0;
        switch (rank) {
            case Normal_User:
                about = 0.9f;
                break;
            case Bronze_User:
                about = 0.7f;
                break;
            case Silver_User:
                about = 0.6f;
                break;
            case Golden_User:
                about = 0.4f;
                break;
            default:
                about = 0.9f;
        }
        Float discount = originCount * about;
        
        return (long)discount.floatValue();
    }
    public static Long moneyToScore(Long money, VIPRank rank) {
        int multiple = 0;
        switch (rank) {
            case Normal_User:
                multiple = 1;
                break;
            case Bronze_User:
                multiple = 2;
                break;
            case Silver_User:
                multiple = 3;
                break;
            case Golden_User:
                multiple = 4;
                break;
            default:
                break;
        }
        return money*multiple;
    }
}
