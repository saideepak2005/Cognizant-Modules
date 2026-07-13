import { mount, shallow } from 'enzyme';
import CohortDetails from './CohortDetails';
import cohortData from './Cohort';

describe('Cohort Details Component', () => {
    test('should create the component', () => {
        const wrapper = shallow(<CohortDetails cohort={cohortData[0]} />);
        expect(wrapper.exists()).toBe(true);
    });

    test('should initialize the props', () => {
        const wrapper = mount(<CohortDetails cohort={cohortData[0]} />);
        expect(wrapper.props().cohort).toEqual(cohortData[0]);
    });

    test('should display cohort code in h3', () => {
        const wrapper = mount(<CohortDetails cohort={cohortData[0]} />);
        const h3 = wrapper.find('h3');
        expect(h3.text()).toBe(cohortData[0].code);
    });

    test('should always render same html', () => {
        const wrapper = shallow(<CohortDetails cohort={cohortData[0]} />);
        expect(wrapper).toMatchSnapshot();
    });
});
