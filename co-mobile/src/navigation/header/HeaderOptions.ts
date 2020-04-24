import {colors} from '../../styles/Colors';

export function HeaderOptionsNoTitle() {
  const options: any = {
    title: '',
    headerStyle: {
      backgroundColor: colors.primary_white,
      height: 0,
    },
    headerTintColor: colors.primary_black,
    headerTitleStyle: {
      fontSize: 25,
    },
  };
  return options;
}

export function HeaderOptionsWithTitle(title: string) {
  const options: any = {
    title: title,
    headerStyle: {
      backgroundColor: colors.primary_white,
      height: 50,
    },
    headerTintColor: colors.primary_black,
    headerTitleStyle: {
      fontWeight: '200',
      fontSize: 25,
    },
  };
  return options;
}
