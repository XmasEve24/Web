package test;

import java.util.Map;

public class CollectionTest {
   private Map<String,String> members;
   // 1쌍의 데이터로 관리되는 컬렉션
   public Map<String, String> getMembers() {
      return members;
   }

   public void setMembers(Map<String, String> members) {
      this.members = members;
   }
      
   /*private Set<String> nameSet;
   // 중복데이터xxx,순서xxx
   public Set<String> getNameSet() {
      return nameSet;
   }

   public void setNameSet(Set<String> nameSet) {
      this.nameSet = nameSet;
   }*/
   
   /*private List<String> memo;

   public List<String> getMemo() {
      return memo;
   }

   public void setMemo(List<String> memo) {
      this.memo = memo;
   }*/
}