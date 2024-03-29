import React from 'react';
import {AsyncStorage, ScrollView, View} from 'react-native';
import {Button, Icon, Input, Text} from 'react-native-elements';
import {colors} from '../../styles/Colors';
import {UserDetailListItem} from "../../components/UserDetailListItem";
import {Constants} from "../../services/Constants";
import {getUsername, setUsername} from "../../data/Username";
import {getURL, setURL} from "../../data/URL";

export class UserScreen extends React.Component {

    state = {
        userID: "",
        url: "",
        newUserID: "",
        newURL: "",
    }

    componentDidMount = () => {
        getUsername()
            .then((userID) => {
                this.setState({userID: userID})
            })
        getURL()
            .then((url) => {
                this.setState({url: url})
            })
    }

    onSaveUsername = (id: string) => {
        try {
            setUsername(id)
                .then(() => {
                    getUsername()
                        .then((userID) => {
                            this.setState({
                                userID: userID,
                                newUserID: ""
                            })
                        })
                });
        } catch (error) {
            console.log(error)
        }
    }

    onSaveURL = (url: string) => {
        try {
            setURL(url)
                .then(() => {
                    getURL()
                        .then((url) => {
                            this.setState({
                                url: url,
                                newURL: ""
                            })
                        })
                });
        } catch (error) {
            console.log(error)
        }
    }

    render() {
        return (
            <ScrollView style={{flex: 1, backgroundColor: colors.light_grey}}>
                <View style={{alignItems: "center", marginTop: 50, marginBottom: 10}}>
                    <Icon
                        name="user"
                        type="evilicon"
                        color={colors.primary_light_green}
                        size={150}
                    />
                    <Text style={{fontSize: 30, color: colors.dark_grey, marginTop: 10, marginBottom: 40}}>
                        {this.state.userID}
                    </Text>
                    <UserDetailListItem title={"Name"} subtitle={"Max Mustermann"}/>
                    <UserDetailListItem title={"Email"} subtitle={"max.mustermann@example.com"}/>

                    <View style={{width: "100%", backgroundColor: colors.primary_white, paddingHorizontal: 5, paddingVertical:20, marginTop: 30}}>
                        <Input
                            label={"Enter new username"}
                            labelStyle={{color: colors.dark_grey, fontWeight: "normal"}}
                            placeholder="Example: max.mustermann"
                            value={this.state.newUserID}
                            onChangeText={(value) => {
                                console.log(value);
                                this.setState({newUserID: value});
                            }}
                        />
                        <Button
                            title={"Save Username"}
                            titleStyle={{color: colors.primary_light_green, textAlign:"center", justifyContent: "center"}}
                            buttonStyle={{marginHorizontal: 50, marginTop: 30, backgroundColor: colors.primary_white, borderWidth: 2, borderColor: colors.primary_light_green, borderRadius: 500, alignItems: "center", paddingHorizontal:50, justifyContent: "center"}}
                            onPress={() => {this.onSaveUsername(this.state.newUserID)}} />
                    </View>
                    <View style={{width: "100%", backgroundColor: colors.primary_white, paddingHorizontal: 5, paddingVertical:20, marginTop: 30, marginBottom: 50}}>
                        <Input
                            label={"Enter server URL"}
                            labelStyle={{color: colors.dark_grey, fontWeight: "normal"}}
                            placeholder={"Current: " + this.state.url}
                            value={this.state.newURL}
                            onChangeText={(value) => {
                                console.log(value);
                                this.setState({newURL: value});
                            }}
                        />
                        <Button
                            title={"Save URL"}
                            titleStyle={{color: colors.primary_light_green, textAlign:"center", justifyContent: "center"}}
                            buttonStyle={{marginHorizontal: 50, marginTop: 30, backgroundColor: colors.primary_white, borderWidth: 2, borderColor: colors.primary_light_green, borderRadius: 500, alignItems: "center", paddingHorizontal:50, justifyContent: "center"}}
                            onPress={() => {this.onSaveURL(this.state.newURL)}} />
                    </View>
                </View>
            </ScrollView>
        );
    }
}
