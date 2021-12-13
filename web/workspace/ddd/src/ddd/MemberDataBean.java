package ddd;


import java.util.ArrayList;

public class MemberDataBean {
    ArrayList<MemberBean> datas = new ArrayList<>();

    public MemberBean show(int i){
        return datas.get(i);

    }

    public ArrayList<MemberBean> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<MemberBean> datas) {
        this.datas = datas;
    }

    public void add(MemberBean mb){
        datas.add(mb);
    }

    public MemberBean search(String sname) {
        for (MemberBean v : datas) {
            if (v.getUname().equals(sname)) {
                System.out.println(sname);
                return v;
            }
        }
        return null;
    }
}
