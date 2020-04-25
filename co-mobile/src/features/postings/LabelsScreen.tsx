import React from 'react';
import {ScrollView, TouchableOpacity, View} from 'react-native';
import {Icon, ListItem, Overlay, Text, Input, Button, SearchBar} from 'react-native-elements';
import {colors} from '../../styles/Colors';
import {Label} from "./interfaces/Label";
import {NavigationStackProp} from "react-navigation-stack";
import {fetchData, postLabel} from "../../services/rest/FetchData";
import {Routes} from "../../services/api/Routes";
import {searchLabel} from "../../data/Search";

interface Props {
    navigation: NavigationStackProp<{data: string}>;
    route: any;
}

export class LabelsScreen extends React.Component <Props> {

    state = {
        overlayVisible: false,
        displayList: [],
        labelsList: [],
        newLabelValue: "",
        searchText: ""
    }

    componentDidMount = () => {
        this.props.navigation.setOptions({
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
        fetchData(Routes.LABELS, "GET")
            .then((result: any) => {
                console.log(result);
                this.setState({
                    displayList: result,
                    labelsList: result
                });
            })
            .catch((error:any) => {
                console.log(error);
            });
    }

    onAddLabelPressed = (value: string) => {
        postLabel(value)
            .then((result: any) => {
                this.setState({
                    overlayVisible: false,
                    labelsList: result
                });
            })
            .catch((error:any) => {
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
                            <Text h4 h4Style={{color: colors.dark_grey}}>{"Add a new label"}</Text>
                            <Text style={{color: colors.dark_grey, marginTop: 20}}>{"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut."}</Text>
                            <Input
                                containerStyle={{marginTop: 30}}
                                label={"Name of your label"}
                                labelStyle={{color: colors.dark_grey}}
                                placeholder='Example: #experiences'
                                value={this.state.newLabelValue}
                                onChangeText={(value) => {
                                    console.log(value);
                                    this.setState({newLabelValue: value});
                                }}
                            />
                            <Button
                                title={"ADD LABEL"}
                                titleStyle={{color: colors.primary_light_green, textAlign:"center", justifyContent: "center"}}
                                buttonStyle={{marginTop: 40, backgroundColor: colors.primary_white, borderWidth: 2, borderColor: colors.primary_light_green, borderRadius: 500, alignItems: "center", paddingHorizontal:50, justifyContent: "center"}}
                                onPress={() => {this.onAddLabelPressed(this.state.newLabelValue)}} />
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
                            this.props.navigation.navigate("Postings", {
                                label: item,
                            });
                        }}
                    />
                ))}
            </ScrollView>
        );
    }
}
