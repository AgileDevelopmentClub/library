<template>
    <LendingList/>
</template>
<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import LendingList from '@/components/LendingList.vue';
@Component({
  components: { LendingList },
})
export default class LendingListView extends Vue {
}
</script>
