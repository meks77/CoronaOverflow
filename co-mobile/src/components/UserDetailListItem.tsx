import React from 'react';
import {ListItem} from 'react-native-elements';
import {colors} from "../styles/Colors";

interface Props {
    title: string;
    subtitle: string;
}

export class UserDetailListItem extends React.Component<Props> {
    render() {
        return (
            <ListItem
                title={this.props.title}
                containerStyle={{
                    backgroundColor: colors.primary_white,
                    width: '100%'
                }}
                titleStyle={{color: colors.dark_grey, fontSize: 15, marginBottom: 3}}
                subtitleStyle={{color: colors.dark_grey, fontSize: 18}}
                subtitle={this.props.subtitle}
                bottomDivider
            />
        );
    }
}
