import React from 'react';
import {AsyncStorage, ScrollView, View} from 'react-native';
import {Button, Icon, Input, Text} from 'react-native-elements';
import {colors} from '../../styles/Colors';
import {UserDetailListItem} from "./components/UserDetailListItem";
import {Constants} from "../../services/Constants";

export class UserScreen extends React.Component {

    state = {
        userID: "",
        newUserID: ""
    }

    componentDidMount = () => {
        AsyncStorage.getItem(Constants.KEY_USERID)
            .then((userID) => {
                this.setState({userID: userID})
            })
    }

    onSaveUsername = (userID: string) => {
        try {
            AsyncStorage.setItem(Constants.KEY_USERID, userID)
                .then(() => {
                    AsyncStorage.getItem(Constants.KEY_USERID)
                        .then((userID) => {
                            this.setState({userID: userID})
                        });
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
                        {this.state.userID ? this.state.userID : "NO_USERID"}
                    </Text>
                    <UserDetailListItem title={"Name"} subtitle={"Max Mustermann"}/>
                    <UserDetailListItem title={"Email"} subtitle={"max.mustermann@example.com"}/>

                    <View style={{width: "100%", backgroundColor: colors.primary_white, paddingHorizontal: 5, paddingVertical:20, marginTop: 30, marginBottom: 50}}>
                    <Input
                        containerStyle={{}}
                        label={"Enter new username"}
                        labelStyle={{color: colors.dark_grey}}
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
                </View>
            </ScrollView>
        );
    }
}
