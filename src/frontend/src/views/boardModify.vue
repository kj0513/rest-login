<template>
  <v-flex xs12>
      <v-form style="width:800px;margin:0 auto;">
            <v-text-field
                placeholder="제목을 입력해주세요"
                name="writer_title"
                v-model="board.bTitle"
                label="제목"
            ></v-text-field>
          <v-textarea
            name="writer_content"
            rows="6"
            v-model="board.bContent"
            value="내용을 입력해주세요"
            ></v-textarea>
        </v-form>
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
            <v-btn @click="BoardModify(board)">수정완료</v-btn>
          </td>
        </tr>
      </table>
  </v-flex>
</template>
<script>
import { mapActions, mapState } from "vuex"
export default {
    created() {
      this.board = this.$store.state.board_detail
    },
    data() {
      return {
        bId : this.$route.params.bId,
        writer_title:null,
        writer_content:null,
        board: null,
      }
    },
    computed: {
       ...mapState(["board_detail"])
    },
    methods: {
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