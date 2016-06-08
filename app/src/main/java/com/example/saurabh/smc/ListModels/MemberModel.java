package com.example.saurabh.smc.ListModels;

/**
 * Created by Saurabh on 5/27/2016.
 */
public class MemberModel {


    private String member_list_name;
    private String member_list_designation;
    private int member_list_mobile;



    public MemberModel(String member_list_name,String member_list_designation, int member_list_mobile) {
        this.member_list_name = member_list_name;
        this.member_list_designation = member_list_designation;
        this.member_list_mobile = member_list_mobile;

    }

    public String getMember_list_name() {
        return member_list_name;
    }

    public void setMember_list_name(String member_list_name) {
        this.member_list_name = member_list_name;
    }

    public String getMember_list_designation() {
        return member_list_designation;
    }

    public void setMember_list_designation(String member_list_designation) {
        this.member_list_designation = member_list_designation;
    }

    public int getMember_list_mobile() {
        return member_list_mobile;
    }

    public void setMember_list_mobile(int member_list_mobile) {
        this.member_list_mobile = member_list_mobile;
    }

}
