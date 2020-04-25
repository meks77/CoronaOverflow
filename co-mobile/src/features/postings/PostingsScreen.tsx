import React from 'react';
import {ScrollView, View} from 'react-native';
import {Card, Divider, Icon, ListItem, Text} from 'react-native-elements';
import {NavigationStackProp} from 'react-navigation-stack';
import {colors} from '../../styles/Colors';
import {Label} from "./interfaces/Label";
import {Posting} from "./interfaces/Posting";


interface Props {
    navigation: NavigationStackProp<{label: Label}>;
    route: any;
};

export class PostingsScreen extends React.Component<Props> {

    state = {
        postingsList: [],
    }

    componentDidMount = () => {
        const label: Label = this.props.route.params.label;
        this.props.navigation.setOptions({ title: label.label });
        const postingsList = require("../../data/Postings")
        this.setState({postingsList: postingsList});
    }

    render() {
        return (
            <ScrollView style={{flex: 1, backgroundColor: colors.light_grey}}>
                <View style={{paddingBottom:25}}>
                {this.state.postingsList.map((item: Posting, i: number) => (
                    <Card key={i}>
                        <View style={{flexDirection: "row", marginBottom: 10}}>
                            <Icon
                                name="user"
                                type="evilicon"
                                color={colors.primary_light_green}
                                size={40}
                            />
                            <Text style={{fontSize: 25, color: colors.dark_grey}}>
                                {item.username}
                            </Text>
                        </View>
                        <Divider />
                        <Text style={{fontSize: 20, marginVertical: 10, color: colors.dark_grey}}>
                            {item.title}
                        </Text>
                        <Text style={{marginBottom: 10, color: colors.dark_grey}}>
                            {item.text}
                        </Text>
                    </Card>
                ))}
                </View>
            </ScrollView>
        );
    }
}
