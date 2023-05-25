/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react'
import { Platform, StyleSheet, Text, View, Button } from 'react-native'
import UdeskAPI from 'react-native-udesk'
const instructions = Platform.select({
  ios: 'Press Cmd+R to reload,\n' + 'Cmd+D or shake for dev menu',
  android:
    'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu'
})

type Props = {}
export default class App extends Component<Props> {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>Welcome to React Native!</Text>
        <Text style={styles.instructions}>To get started, edit App.js</Text>
        <Text style={styles.instructions}>{instructions}</Text>
        <Button
          onPress={() => {
            const params = {
              productImageUrl:
                'https://qn-im.udesk.cn/570D6DB3-113D-4310-921A-F5E66D158CC2-2017-04-05-03-42-33.jpg',
              productTitle:
                '测试测试测试测你测试测试测你测试测试测你测试测试测你测试测试测你测试测试测你！',
              productDetail: '¥9988888.088888.088888.0',
              productURL: 'http://www.xebest.com'
            }
            UdeskAPI.createCommodity(params, response => {})
          }}
          title="Press Me"
        />
        <Button
          onPress={() => {
            const user = {
              nick_name: 'fang',
              cellphone: '15880064924',
              sdk_token:'sduaifh1223hi2u3h4ui',
              icon:'https://www.baidu.com/img/bd_logo1.png'
            }
            UdeskAPI.setUserInfo(user, response => {})
          }}
          title="setUser"
        />
      </View>
    )
  }
  componentWillMount() {
    UdeskAPI.initSDK(
      '15880064924.udesk.cn',
      'be40c180708f5596ab9b7609d7ef83a9',
      '856da9aa37f36129'
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF'
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5
  }
})
