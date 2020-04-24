import React from 'react';
import {ScrollView} from 'react-native';
import {ListItem} from 'react-native-elements';
import {colors} from '../../styles/Colors';
import {Label} from "./interfaces/Label";
import {NavigationStackProp} from "react-navigation-stack";

interface Props {
    navigation: NavigationStackProp<{data: string}>;
    route: any;
}

export class LabelsScreen extends React.Component <Props> {

    state = {
        labelsList: [],
    }

    componentDidMount = () => {
        const labelsList = require("../../data/Labels");
        this.setState({labelsList: labelsList});
    }

    render() {
        return (
            <ScrollView style={{flex: 1, backgroundColor: colors.light_grey}}>
                {this.state.labelsList.map((item: Label, i: number) => (
                    <ListItem
                        key={i}
                        title={item.label}
                        containerStyle={{
                            backgroundColor: colors.primary_white
                        }}
                        titleStyle={{color: colors.primary_light_green, fontSize:20}}
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
