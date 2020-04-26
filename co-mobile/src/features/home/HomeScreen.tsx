import React from 'react';
import {ScrollView, View} from 'react-native';
import {Card, ListItem, Text} from 'react-native-elements';
import {colors} from '../../styles/Colors';
import {WHOAdvices} from "../../data/Advices";

export class HomeScreen extends React.Component {
  state = {
    advices: {
      title: "",
      subtitle: "",
      faq: [
        {
          question: " ",
          answer: ""
        }
      ]
    }
  }

  componentDidMount = () => {
    this.setState({advices: WHOAdvices})
  }

  render() {
    return (
        <ScrollView style={{flex: 1, backgroundColor: colors.light_grey}}>
          <ListItem
              title={this.state.advices.title}
              containerStyle={{
                backgroundColor: colors.primary_white,
                width: '100%',
                paddingVertical: 25
              }}
              titleStyle={{color: colors.primary_light_green, fontSize: 25, marginBottom: 10}}
              subtitleStyle={{color: colors.dark_grey, fontSize: 17, lineHeight: 25}}
              subtitle={this.state.advices.subtitle}
              bottomDivider
          />
          <View style={{paddingBottom:25}}>
            {this.state.advices.faq.map((item, i: number) => (
                <Card
                    key={i}
                    title={item.question}
                    titleStyle={{textAlign: "left", fontSize: 20, fontWeight: "normal", color: colors.primary_light_green}}
                    containerStyle={{marginVertical: 30}}>
                  <Text style={{marginBottom: 10, fontSize: 17, lineHeight: 25, color: colors.dark_grey}}>
                    {item.answer}
                  </Text>
                </Card>
            ))}
          </View>
            <Text style={{marginBottom: 0, marginTop: 10, fontSize: 15, fontWeight: "bold", lineHeight: 20, color: colors.dark_grey, paddingHorizontal: 20}}>Source:</Text>
            <Text style={{marginBottom: 50, fontSize: 15, lineHeight: 20, color: colors.dark_grey, paddingHorizontal: 20}}>https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public</Text>
        </ScrollView>
    );
  }
}
