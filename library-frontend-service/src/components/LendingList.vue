<template>
  <v-container>
    <v-toolbar flat color="white" class="elevation-1">
      <v-toolbar-title>貸出中一覧</v-toolbar-title>
      <v-divider class="mx-2" inset vertical></v-divider>
      <v-spacer></v-spacer>
      <v-text-field
        v-model="search"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
    </v-toolbar>
    <v-data-table :headers="headers" :items="lendingRecords" class="elevation-1" :search="search">
      <template v-slot:items="props">
        <td>{{ props.item.title }}</td>
        <td>{{ props.item.userId }}</td>
      </template>
      <template v-slot:no-data> </template>
    </v-data-table>
  </v-container>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import { LendingRecordsApi } from '@/generated';
import LendingRecord from '@/class/LendingRecord';
import { Constant } from '@/class/Constant';
import Isbn from '@/class/Isbn';

import customConfiguration = Constant.customConfiguration;

@Component
export default class LendingList extends Vue {
  search: string = '';

  lendingRecords: Array<LendingRecord> = [];

  headers: any = [
    { text: 'タイトル', value: 'title' },
    { text: 'userId', value: 'userId' },
    { text: 'user', value: 'fullName' },
  ];

    bookApi: LendingRecordsApi = new LendingRecordsApi(customConfiguration);

    /**
     * 貸出帳をサーバーから取得する。
     */
    getBooks(): void {
      this.bookApi.lendingRecordsGet()
        .then(async (res) => {
          const lendingRecordsDto = res.data.lendingRecords;

          if (typeof lendingRecordsDto === 'undefined') {
            return;
          }

          // Promiseの配列を生成
          const b = lendingRecordsDto.map(item => this.createLendingRecord(item));

          // 配列bに入っている処理がすべて終わるまで、await
          // 並列処理を行う。
          await Promise.all(b);
        });
    }

    /**
      * ライフサイクル：mounted
      */
    mounted(): void {
      this.getBooks();
    }

    /**
    * サーバーから取得した値を元にクライアントの貸出帳を作成する。
    * @param lendingRecordDto
    */
    async createLendingRecord(lendingRecordDto : any): Promise<void> {
      const isbn = new Isbn(lendingRecordDto.isbn);
      const lendingRecord = new LendingRecord(isbn,
        lendingRecordDto.userId,
        await isbn.getTitle(),
        lendingRecordDto.simei,
        lendingRecordDto.namae);
      this.lendingRecords.push(lendingRecord);
    }
}
</script>
