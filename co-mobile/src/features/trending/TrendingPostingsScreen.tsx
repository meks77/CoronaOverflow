import React from 'react';
import {ScrollView, TouchableOpacity, View} from 'react-native';
import {NavigationStackProp} from 'react-navigation-stack';
import {colors} from '../../styles/Colors';
import {Label} from "../../interfaces/Label";
import {Posting} from "../../interfaces/Posting";
import {PostingsCard} from "../../components/PostingsCard";
import {fetchData, sendVoting} from "../../services/rest/FetchData";
import {Button, Icon, Input, Overlay, SearchBar, Text} from "react-native-elements";
import {searchPosting} from "../../data/Search";
import {getUsername} from "../../data/Username";

interface Props {
    navigation: NavigationStackProp<{label: Label}>;
    route: any;
};

export class TrendingPostingsScreen extends React.Component<Props> {

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
        this.props.navigation.setOptions({ title: label.label});
        this.fetchPostings();
    }

    fetchPostings = () => {
        const label: Label = this.props.route.params.label;
        fetchData(label.link.url, label.link.method)
            .then((result: any) => {
                console.log(result);
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
        let route = "/voting/postingUUID1/voteUp"
        if (vote === "down") {
            route = "/voting/postingUUID1/voteUp"
        }
        this.updateVote(item, vote);
        console.log(item.votings.links)
        console.log(route)
        getUsername()
            .then((userID: string) => {
                console.log(userID)
                sendVoting(route, userID)
                    .then((response) => {
                        console.log(response);
                    })
            })
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
            <>
                <SearchBar
                    placeholder="Type Here..."
                    value={this.state.searchText}
                    onChangeText={(value) => {
                        this.onSearchTextChange(value);
                    }}
                    lightTheme={true}
                    containerStyle={{backgroundColor: colors.primary_white}}
                    inputContainerStyle={{backgroundColor: colors.light_grey}} />
                <ScrollView style={{flex: 1, backgroundColor: colors.light_grey}}>
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
            </>
        );
    }
}
