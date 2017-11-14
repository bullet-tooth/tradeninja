<template>
  <main>
    <v-content>
      <v-container>
        <v-layout>
          <h3>user home page</h3>
        </v-layout>
        <v-layout>
          <v-btn @click="showMarkets">Show Bittrex markets</v-btn>
        </v-layout>
        <v-layout v-show="items.length > 0">
          <v-data-table
            :headers="headers"
            :items="items"
            hide-actions
            class="elevation-1"
          >
            <template slot="items" slot-scope="props">
              <td>{{ props.item.MarketName }}</td>
              <td class="text-xs-right">{{ props.item.MarketCurrency }}</td>
              <td class="text-xs-right">{{ props.item.MarketCurrencyLong }}</td>
              <td class="text-xs-right">{{ props.item.BaseCurrency }}</td>
              <td class="text-xs-right">{{ props.item.MinTradeSize }}</td>
            </template>
          </v-data-table>
        </v-layout>
      </v-container>
    </v-content>
  </main>
</template>

<script>
  const APIKEY = ''
  const APISECRET = ''
  var bittrex = require('node-bittrex-api')

  // eslint-disable-next-line no-unused-vars
//  const HEADERS = {
//    'Access-Control-Allow-Origin': '*',
//    'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept'
//  }

  bittrex.options({
    apikey: APIKEY,
    apisecret: APISECRET,
    verbose: true
  })

  export default {
    data () {
      return {
        headers: [
          {text: 'Market Name', value: 'MarketName'},
          {text: 'Market Currency', value: 'MarketCurrency'},
          {text: 'Market Currency Full', value: 'MarketCurrencyLong'},
          {text: 'Base Currency', value: 'BaseCurrency'},
          {text: 'Min Trade Size', value: 'MinTradeSize'}
        ],
        items: []
      }
    },
    methods: {
      showMarkets: function () {
        this.items = []
        console.log('showMarkets clicked!!')
//        let url = 'https://bittrex.com/api/v1.1/public/getmarkets'
//        this.$http.get(url)
//          .then(responce => {
//            console.log(responce)
//          })
//          .catch(err => {
//            console.log(err)
//          })
        bittrex.getmarkets(function (data, err) {
          if (err) {
            return console.error(err)
          }
          for (let i in data.result) {
            if (i.IsActive) {
              this.items.push(i)
            }
          }
        })
      }
    }
  }
</script>
