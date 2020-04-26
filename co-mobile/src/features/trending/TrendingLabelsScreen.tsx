import React from 'react';
import {ScrollView, TouchableOpacity, View} from 'react-native';
import {Icon, ListItem, Overlay, Text, Input, Button, SearchBar} from 'react-native-elements';
import {colors} from '../../styles/Colors';
import {Label} from "../../interfaces/Label";
import {NavigationStackProp} from "react-navigation-stack";
import {fetchData} from "../../services/rest/FetchData";
import {Routes} from "../../services/api/Routes";
import {searchLabel} from "../../data/Search";

interface Props {
    navigation: NavigationStackProp<{data: string}>;
    route: any;
}

export class TrendingLabelsScreen extends React.Component <Props> {

    state = {
        overlayVisible: false,
        displayList: [],
        labelsList: [],
        newLabelValue: "",
        searchText: ""
    }

    componentDidMount = () => {
        console.log("mounted")
        fetchData(Routes.TRENDS, "GET")
            .then((result: any) => {
                console.log(result);
                this.setState({
                    displayList: result,
                    labelsList: result
                });
                console.log("Fetching completed")
            })
            .catch((error:any) => {
                console.log("Fetching error")
                console.log(error);
            });
    }

    onSearchTextChange = (value: string) => {
        if (value.length > 0) {
            console.log(value);
            const displayList = searchLabel(this.state.labelsList as never, value);
            this.setState({
                searchText: value,
                displayList: displayList
            });
        }
        else {
            this.setState(({
                searchText: value,
                displayList: this.state.labelsList
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
                    {this.state.displayList.map((item: Label, i: number) => (
                        <ListItem
                            key={i}
                            title={item.label}
                            containerStyle={{
                                backgroundColor: colors.primary_white
                            }}
                            titleStyle={{color: colors.primary_light_green, fontSize: 20}}
                            subtitleStyle={{color: colors.dark_grey}}
                            subtitle={item.description}
                            bottomDivider
                            chevron={{color: colors.primary_light_green}}
                            onPress={() => {
                                this.props.navigation.navigate("TrendingPostings", {
                                    label: item,
                                });
                            }}
                        />
                    ))}
                </ScrollView>
            </>
        );
    }
}
