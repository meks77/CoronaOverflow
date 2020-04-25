import React from 'react';
import {ScrollView, TouchableOpacity, View} from 'react-native';
import {NavigationStackProp} from 'react-navigation-stack';
import {colors} from '../../styles/Colors';
import {Label} from "./interfaces/Label";
import {Posting} from "./interfaces/Posting";
import {PostingsCard} from "./components/PostingsCard";
import {fetchData} from "../../services/rest/FetchData";
import {Button, Icon, Input, Overlay, SearchBar, Text} from "react-native-elements";
import {searchLabel, searchPosting} from "../../data/Search";

interface Props {
    navigation: NavigationStackProp<{label: Label}>;
    route: any;
};

export class PostingsScreen extends React.Component<Props> {

    state = {
        overlayVisible: false,
        displayList: [],
        postingsList: [],
        newPostingTitle: "",
        newPostingMessage: "",
        searchText: ""
    }

    componentDidMount = () => {
        const label: Label = this.props.route.params.label;
        this.props.navigation.setOptions({ title: label.label,
            headerRight: () => (
                <TouchableOpacity style={{marginRight: 10}} onPress={() => this.setState({overlayVisible: true})}>
                    <Icon
                        name="add"
                        type="material"
                        color={colors.dark_grey}
                        size={35}
                    />
                </TouchableOpacity>
            )});
        fetchData(label.link.url, label.link.method)
            .then((result: any) => {
                console.log(result);
                //this.setState({labelsList: result});
                this.setState({
                    postingsList: result,
                    displayList: result
                });
            })
            .catch((error:any) => {
                console.log(error);
            });
    }

    sendVote = (item: Posting, vote: string) => {
        vote = this.checkVote(item, vote);
        this.updateVote(item, vote);
    }

    checkVote = (item: Posting, vote: string): string =>    {
        if (item.votings.voted !== null) {
            if (item.votings.voted === "up") {
                if (vote === "down") {
                    vote = "down"
                } else {
                    vote = ""
                }
            } else if (item.votings.voted === "down"){
                if (vote === "up") {
                    vote = "up"
                } else {
                    vote = ""
                }
            }
        }
        return vote
    }

    updateVote = (item: Posting, vote: string) => {
        const list = this.state.postingsList;
        const newItem = item;
        if (vote === "") {
            if (item.votings.voted === "up") {
                newItem.votings.up = newItem.votings.up - 1;
            } else if (item.votings.voted === "down") {
                newItem.votings.down = newItem.votings.down - 1;
            }
        } else if (vote === "up"){
            if (item.votings.voted === "down") {
                newItem.votings.down = newItem.votings.down - 1;
            }
            newItem.votings.up = newItem.votings.up + 1;
        } else if (vote === "down") {
            if (item.votings.voted === "up") {
                newItem.votings.up = newItem.votings.up - 1;
            }
            newItem.votings.down = newItem.votings.down + 1;
        }
        newItem.votings.voted = vote;
        const indexOfItem = list.indexOf(item as never);
        list[indexOfItem] = newItem;
        this.setState({postingsList: list});
    }

    onAddPostPressed = (title: string, message: string) => {
        this.setState({overlayVisible: false});
        console.log(title, message);
    }

    onSearchTextChange = (value: string) => {
        if (value.length > 0) {
            console.log(value);
            const displayList = searchPosting(this.state.postingsList as never, value);
            this.setState({
                searchText: value,
                displayList: displayList
            });
        }
        else {
            this.setState(({
                searchText: value,
                displayList: this.state.postingsList
            }))
        }
    }

    render() {
        return (
            <ScrollView style={{flex: 1, backgroundColor: colors.light_grey}}>
                <Overlay isVisible={this.state.overlayVisible}>
                    <View style={{flex: 1}}>
                        <View style={{width: "100%", alignItems: "flex-end"}}>
                            <TouchableOpacity style={{}} onPress={() => this.setState({overlayVisible: false})}>
                                <Icon
                                    name="close"
                                    type="material"
                                    color={colors.dark_grey}
                                    size={35}
                                />
                            </TouchableOpacity>
                        </View>
                        <View style={{flex: 1, justifyContent: "center", alignItems: "center", padding: 10}}>
                            <Text h4 h4Style={{color: colors.dark_grey}}>{"Add a new post"}</Text>
                            <Text style={{color: colors.dark_grey, marginTop: 20}}>{"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut."}</Text>
                            <Input
                                containerStyle={{marginTop: 30}}
                                label={"Title of your post"}
                                placeholder='Example: Hello World'
                                value={this.state.newPostingTitle}
                                onChangeText={(value) => {
                                    console.log(value);
                                    this.setState({newPostingTitle: value});
                                }}
                            />
                            <Input
                                containerStyle={{marginTop: 30}}
                                label={"Message of your post"}
                                placeholder='Example: What a beautiful day!'
                                value={this.state.newPostingMessage}
                                onChangeText={(value) => {
                                    console.log(value);
                                    this.setState({newPostingMessage: value});
                                }}
                                multiline={true}
                            />
                            <Button
                                title={"POST"}
                                titleStyle={{color: colors.primary_light_green, textAlign:"center", justifyContent: "center"}}
                                buttonStyle={{marginTop: 40, backgroundColor: colors.primary_white, borderWidth: 2, borderColor: colors.primary_light_green, borderRadius: 500, alignItems: "center", paddingHorizontal:50, justifyContent: "center"}}
                                onPress={() => {this.onAddPostPressed(this.state.newPostingTitle, this.state.newPostingMessage)}} />
                        </View>
                    </View>
                </Overlay>
                <SearchBar
                    placeholder="Type Here..."
                    value={this.state.searchText}
                    onChangeText={(value) => {
                        this.onSearchTextChange(value);
                    }}
                    lightTheme={true}
                    containerStyle={{backgroundColor: colors.primary_white}}
                    inputContainerStyle={{backgroundColor: colors.light_grey}} />
                <View style={{paddingBottom:25}}>
                {this.state.displayList.map((item: Posting, i: number) => (
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
