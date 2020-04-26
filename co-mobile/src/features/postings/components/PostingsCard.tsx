import React from 'react';
import {View} from 'react-native';
import {Button, Card, Divider, Icon, Text} from 'react-native-elements';
import {colors} from "../../../styles/Colors";
import {Posting} from "../interfaces/Posting";
import Moment from 'moment';

interface Props {
    key: number,
    item: Posting,
    onVote(vote: string): any,
}

export class PostingsCard extends React.Component<Props> {
    render() {
        return (
            <Card key={this.props.key}>
                <View style={{flexDirection: "row", marginBottom: 10}}>
                    <Icon
                        name="user"
                        type="evilicon"
                        color={colors.primary_light_green}
                        size={70}
                    />
                    <View style={{justifyContent:"center"}}>
                        <Text style={{fontSize: 25, color: colors.dark_grey, marginLeft: 5}}>
                            {this.props.item.userID}
                        </Text>
                        <Text style={{fontSize: 15, marginLeft: 5, marginTop: 2, color: colors.dark_grey}}>
                            {Moment(this.props.item.date).format('DD.MM.YYYY HH:mm')}
                        </Text>
                    </View>
                </View>
                <Divider />
                <Text style={{fontSize: 20, marginVertical: 10, color: colors.dark_grey}}>
                    {this.props.item.title}
                </Text>
                <Text style={{marginBottom: 30, color: colors.dark_grey}}>
                    {this.props.item.text}
                </Text>
                <View style={{flexDirection: "row"}}>
                    <Button
                        icon={
                            <Icon
                                name="arrow-up"
                                type="evilicon"
                                color={this.props.item.votings.voted && (this.props.item.votings.voted === "up") ? colors.primary_light_green : colors.dark_grey}
                                size={35}
                            />
                        }
                        title={"" + this.props.item.votings.up}
                        buttonStyle={{backgroundColor: colors.primary_white, width: 75}}
                        titleStyle={{color: colors.dark_grey, fontSize: 20}}
                        onPress={() => {
                            this.props.onVote("up");
                        }}
                    />
                    <Button
                        icon={
                            <Icon
                                name="arrow-down"
                                type="evilicon"
                                color={this.props.item.votings.voted && (this.props.item.votings.voted === "down") ? colors.primary_light_green : colors.dark_grey}
                                size={35}
                            />
                        }
                        title={"" + this.props.item.votings.down}
                        buttonStyle={{backgroundColor: colors.primary_white, marginLeft: 20, width: 75}}
                        titleStyle={{color: colors.dark_grey, fontSize: 20}}
                        onPress={() => {
                            this.props.onVote("down");
                        }}
                    />
                </View>
            </Card>
        );
    }
}
