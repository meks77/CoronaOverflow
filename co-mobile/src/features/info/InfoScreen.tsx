import React from 'react';
import {ScrollView} from 'react-native';
import {Text} from 'react-native-elements';
import {colors} from '../../styles/Colors';

export class InfoScreen extends React.Component {
    render() {
        return (
            <ScrollView style={{flex: 1, backgroundColor: colors.primary_white, padding: 20}}>
                <Text style={{color: colors.primary_light_green, fontSize: 25, marginTop: 20, marginBottom: 10}}>About CoronaOverflow</Text>
                <Text style={{color: colors.dark_grey, fontSize: 17, lineHeight: 25}}>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</Text>
                <Text style={{color: colors.primary_light_green, fontSize: 25, marginBottom: 10, marginTop: 40}}>Contributors</Text>
                <Text style={{color: colors.dark_grey, fontSize: 17, lineHeight: 25}}>{"- Hager Markus\n- Reisenbauer Sarah\n- Soelkner Markus\n- Vojinovic Milan"}</Text>
                <Text style={{color: colors.primary_light_green, fontSize: 25, marginBottom: 10, marginTop: 40}}>Supported by</Text>
                <Text style={{color: colors.dark_grey, fontSize: 17, lineHeight: 25, marginBottom:80}}>{"IT-Services der Sozialversicherung GmbH\nJohann-Böhm-Platz 1\n1020 Vienna, Austria"}</Text>
            </ScrollView>
        );
    }
}
