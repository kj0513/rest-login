<template>
    <v-flex xs12 >
        <v-form style="width:800px;margin:0 auto;">
            <v-text-field
                value="제목을 입력해주세요"
                name="writer_title"
                v-model="writer_title"
                label="제목"
            ></v-text-field>
          <v-textarea
            name="writer_content"
            rows="6"
            v-model="writer_content"
            value="내용을 입력해주세요"
            ></v-textarea>
        </v-form>
        <v-btn @click="boardWrite({username: Userinfo.User_Id, bTitle: writer_title, bContent: writer_content})">등록</v-btn>
    </v-flex>
    
</template>
<script>
import { mapState,mapActions } from 'vuex'
export default {
    data() {
        return {
            writer_title:null,
            writer_content:null,
        }
    },
    methods: {
        ...mapActions(['boardWrite'])
    },
    computed: {
        ...mapState(["Userinfo"])
    }
}
</script>