import React from 'react';
import {ScrollView, View} from 'react-native';
import {Card, Divider, Icon, ListItem, Text} from 'react-native-elements';
import {NavigationStackProp} from 'react-navigation-stack';
import {colors} from '../../styles/Colors';
import {Label} from "./interfaces/Label";
import {Posting} from "./interfaces/Posting";
import {PostingsCard} from "./components/PostingsCard";


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

    checkVote = (item: Posting, vote: string): string =>    {
        if (item.voted !== null) {
            if (item.voted === "up") {
                if (vote === "down") {
                    vote = "down"
                } else {
                    vote = ""
                }
            } else if (item.voted === "down"){
                if (vote === "up") {
                    vote = "up"
                } else {
                    vote = ""
                }
            }
        }
        return vote
    }

    sendVote = (item: Posting, vote: string) => {
        vote = this.checkVote(item, vote);
        console.log(vote)
        const list = this.state.postingsList;
        const newItem = item;
        newItem.voted = vote;
        const indexOfItem = list.indexOf(item as never);
        list[indexOfItem] = newItem;
        this.setState({postingsList: list});
    }

    render() {
        return (
            <ScrollView style={{flex: 1, backgroundColor: colors.light_grey}}>
                <View style={{paddingBottom:25}}>
                {this.state.postingsList.map((item: Posting, i: number) => (
                    <PostingsCard
                        key={i}
                        item={item}
                        onVote={(vote) => {
                            this.sendVote(item, vote);
                        }} />
                ))}
                </View>
            </ScrollView>
        );
    }
}
