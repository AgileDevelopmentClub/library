<template>
    <BookList/>
</template>
<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import LendingList from '@/components/LendingList.vue';
@Component({
  components: { BookList: LendingList },
})
export default class BooksInventoryView extends Vue {
}
</script>
