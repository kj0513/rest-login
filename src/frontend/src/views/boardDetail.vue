<template>
  <v-flex xs12>
        <table>
        <tr>
          <td colspan="2" style="font-weight:700;"> {{board_detail.bTitle}}</td>
        </tr>
        <tr style="font-size:0.9rem;">
          <td> 작성자 :  {{board_detail.username}} </td>
          <td style="text-align:right">{{board_detail.bDateTime}}</td>
        </tr>
        <tr>
          <td colspan="2" style="border:none;">{{board_detail.bContent}}</td>
        </tr>
        <tr>
          <td colspan="2" style="border:none;text-align:right;border-top:3px double #ededed">
            <v-btn @click="BoardModify({bId:bId})">수정</v-btn>
            <v-btn @click="BoardDelete({bId:bId})">삭제</v-btn>
            <v-btn  router :to="{name:'boardwrite'}">답글쓰기</v-btn>
          </td>
        </tr>
      </table>


<v-simple-table>
  <template v-slot:default>
      <thead>
        <tr>
          <th class="text-left">
            댓글작성자
          </th>
          <th class="text-left">
            댓글내용
          </th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="item in board_detail.comment"
          :key="item.c_id"
        >
          <td>{{ item.username }}</td>
          <td>{{ item.c_content }}</td>
        </tr>
      </tbody>
    </template>
  </v-simple-table>

      <table>
          <td colspan="2" style="border:none;text-align:right;border-top:3px double #ededed">
            <v-btn @click="CommentModify({cId:cId})">수정</v-btn>
            <v-btn @click="CommentDelete({cId:cId})">삭제</v-btn>
          </td>
      </table>


        <v-form style="width:500px;margin:0 auto;">
          <v-text-field
          name="comment_content"
          v-model="comment_content"
          ></v-text-field>
          <v-btn @click="CommentWrite({username: Userinfo.User_Id, bId: bId, c_content: comment_content})">댓글등록</v-btn>
        </v-form>


        
  </v-flex>
</template>
<script>
import { mapActions, mapState } from "vuex"
export default {
    data() {
      return {
        bId : this.$route.params.bId,
        comment_content:null
      }
    },
    computed: {
       ...mapState(["board_detail","Userinfo"])
    },
    methods: {
      ...mapActions(["BoardDelete","BoardModify","boardWrite","CommentWrite"])
    }
}
</script>
<style scoped>
table {
  width:600px;
  margin:0 auto;
  border-collapse:collapse;
  text-align: center;
}
table tr td {
  border-top:1px solid #ededed;
  border-bottom:1px solid #ededed;
  padding:10px;
}
</style>